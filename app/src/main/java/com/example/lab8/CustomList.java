package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;
    private boolean contain;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    public int getCount(){
        return cities.size();
    }

    public void addCity(City city){
    cities.add(city);
    }

    /**
     * Checks if a city is present in the list.
     *
     * @param city
     *        The City object to check.
     * @return
     *        True if the city is in the list, false otherwise.
     */

    public Boolean hasCity(City city) {
        if (cities.contains(city)) {
            contain = true;
        }
        else {
            contain = false;
        }

        return contain;
    }

    /**
     * Removes a city from the list if it exists.
     * Throws an exception if the city is not present.
     *
     * @param city
     *        The City object to be removed from the list.
     * @throws IllegalArgumentException
     *         If the city is not found in the list.
     */

    public void delete(City city) {
        if (cities.contains(city) != true) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * Returns the total number of cities in the list.
     *
     * @return
     *        The number of City objects in the list.
     */
    public  int countCities(){
        List<City> list = cities;

        return list.size();
    }



}
