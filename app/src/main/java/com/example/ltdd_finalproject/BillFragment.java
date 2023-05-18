package com.example.ltdd_finalproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ltdd_finalproject.Adapter.HoadonAdapter;
import com.example.ltdd_finalproject.Api.ApiService;
import com.example.ltdd_finalproject.Model.Hoadon;
import com.example.ltdd_finalproject.Model.apiHoadon;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BillFragment extends Fragment {
    private RecyclerView rcvHoadon;
    private List<Hoadon> mListHoadon;
    private HoadonAdapter mHoadonAdapter;

    private View mView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_bill, container, false);

//        rcvHoadon= mView.findViewById(R.id.billList);
//
//
        getHoadonRequest();


        return mView;
    }
    private void getHoadonRequest(){
        String token= DataLocalManager.getToken();
        ApiService.apiService.getHoadon(token).enqueue(new Callback<apiHoadon>() {
            @Override
            public void onResponse(Call<apiHoadon> call, Response<apiHoadon> response) {
                Toast.makeText(requireContext(), "call hoa don THANH CONG", Toast.LENGTH_SHORT).show();
//                apiHoadon hd= response.body();

//                mListHoadon = new ArrayList<>();
//                mListHoadon= response.body().getHoa_don();
//
//                Log.e("hhg", String.valueOf(response.body().getHoa_don().size()));
//
//                listViewAdapter adap= new listViewAdapter(mListHoadon);
//                lvHoadon.setAdapter(adap);
                //                mListHoadon= new ArrayList<>();
//                mListHoadon= response.body().getHoa_don();
//
//                mHoadonAdapter= new HoadonAdapter(mListHoadon, requireContext());
//                LinearLayoutManager linearLayoutManager= new LinearLayoutManager(requireContext());
//                rcvHoadon.setLayoutManager(linearLayoutManager);
//
//                DividerItemDecoration itemDecoration= new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL);
//                rcvHoadon.addItemDecoration(itemDecoration);
////                mHoadonAdapter.setData(mListHoadon);
//                rcvHoadon.setAdapter(mHoadonAdapter);
            }

            @Override
            public void onFailure(Call<apiHoadon> call, Throwable t) {
                Toast.makeText(requireContext(), "call hoa don error", Toast.LENGTH_SHORT).show();

            }
        });
    }
}

//
//mListHoadon= response.body();
//        HoadonAdapter hoadonAdapter= new HoadonAdapter(mListHoadon);
//        rcvHoadon.setAdapter(hoadonAdapter);