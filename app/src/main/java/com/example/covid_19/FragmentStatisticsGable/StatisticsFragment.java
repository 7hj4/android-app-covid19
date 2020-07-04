package com.example.covid_19.FragmentStatisticsGable;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.covid_19.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class StatisticsFragment extends Fragment {

    private RecyclerView recyclerView ;
    private ArrayList<Models> mModels;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_statistics, container, false);

        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView.setHasFixedSize(true);

        //call method get data
        getData();
        return view;
    }

    private void showRecyclerView(){
        ViewPagerAdpter viewPagerAdpter = new ViewPagerAdpter(mModels,getActivity());
        recyclerView.setAdapter(viewPagerAdpter);
    }
    private void getData(){

        String url = "https://corona.lmao.ninja/v2/countries"  ;

        mModels = new ArrayList<>();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null) {
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                            JSONObject jsonContryflag = jsonObject.getJSONObject("countryInfo");


                            mModels.add(new Models(
                                    jsonContryflag.getString("flag"),
                                    jsonObject.getString("cases"),
                                    jsonObject.getString("recovered"),
                                    jsonObject.getString("deaths")));
                        }
                        showRecyclerView();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(getActivity()).add(stringRequest);
    }

            }
