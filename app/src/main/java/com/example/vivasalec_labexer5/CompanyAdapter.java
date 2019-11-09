package com.example.vivasalec_labexer5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.List;

public class CompanyAdapter extends ArrayAdapter<CompanyDetail> {

    private Context context;
    private int resource;

    public CompanyAdapter(Context context, int resource, List<CompanyDetail> objects){
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView ( int i, View convertView, ViewGroup parent){

        int logo = getItem(i).getCompanyLogo();
        String name = getItem(i).getCompanyName();
        String country = getItem(i).getCompanyCountry();
        String industry = getItem(i).getCompanyIndustry();
        String ceo = getItem(i).getCompanyCeo();

        LayoutInflater inflater = LayoutInflater.from(context);

        convertView = inflater.inflate(resource, parent, false);

        ImageView CompanyLogo = convertView.findViewById(R.id.ivLogo);
        TextView CompName = convertView.findViewById(R.id.tvName);
        TextView CompCountry = convertView.findViewById(R.id.tvCountry);
        TextView CompIndustry = convertView.findViewById(R.id.tvIndustry);
        TextView CompCeo = convertView.findViewById(R.id.tvCeo);

        CompanyLogo.setImageResource(logo);
        CompName.setText(name);
        CompCountry.setText(country);
        CompIndustry.setText(industry);
        CompCeo.setText(ceo);

        return convertView;
    }
}

