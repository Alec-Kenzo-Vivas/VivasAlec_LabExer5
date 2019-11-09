package com.example.vivasalec_labexer5;

import android.content.DialogInterface;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] CompName, CompCountry, CompIndustry, CompCeo, CompInfo;
    int[] CompanyLogo = {R.drawable.icbc
            ,R.drawable.jpmorganchase,R.drawable.chinaconstructionbank,
            R.drawable.agriculturalbankofchina,R.drawable.bankofamerica,R.drawable.apple,R.drawable.pingan,R.drawable.chinaconstructionbank,
            R.drawable.royaldutchshell,R.drawable.wellsfargo,R.drawable.exxonmobil,R.drawable.att,R.drawable.samsungelectronics,R.drawable.citigroup};
    ArrayList<CompanyDetail> companies= new ArrayList<>();
    ListView listCompanies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CompName = getResources().getStringArray(R.array.CompName);
        CompCountry = getResources().getStringArray(R.array.CompCountry);
        CompIndustry = getResources().getStringArray(R.array.CompIndustry);
        CompCeo = getResources().getStringArray(R.array.CompCeo);
        CompInfo = getResources().getStringArray(R.array.CompInfo);

        for(int i = 0; i < CompName.length; i++){
            companies.add(new CompanyDetail(CompanyLogo[i], CompName[i], CompCountry[i], CompIndustry[i], CompCeo[i], CompInfo[i]));

        }

        CompanyAdapter adapter = new CompanyAdapter(this, R.layout.item, companies);

        listCompanies = findViewById(R.id.lvCompany);

        listCompanies.setAdapter(adapter);

        listCompanies.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int i, long id) {
        final File folder = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        File read = new File(folder, "GetComp.txt");
        try {
            final FileOutputStream show = new FileOutputStream(read);
            final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            String CompanyChoice = companies.get(i).getCompanyName() + "\n" + companies.get(i).getCompanyCountry() + "\n" + companies.get(i).getCompanyIndustry()
                    + "\n" + companies.get(i).getCompanyCeo();
            show.write(CompanyChoice.getBytes());
            dialog.setTitle(companies.get(i).getCompanyName());
            dialog.setIcon(companies.get(i).getCompanyLogo());

            dialog.setMessage(CompInfo[i]);

            dialog.setNeutralButton("CLOSE", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    try {
                        FileInputStream CompFIS;
                        CompFIS = new FileInputStream(new File(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + "/GetComp.txt"));
                        int i;
                        String str = "";
                        while ((i = CompFIS.read()) != -1) {
                            str += Character.toString((char) i);
                        }
                        CompFIS.close();
                        Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
            dialog.create().show();
        } catch (FileNotFoundException e) {
            Toast.makeText(this, "File was not found.", Toast.LENGTH_LONG ).show();
        } catch (IOException e) {
            Toast.makeText(this, "Error: Write was not Successful.", Toast.LENGTH_SHORT).show();
        }

    }
}
