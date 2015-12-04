package br.edu.univas.previsaotempo.view;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import br.edu.univas.previsaotempo.R;
import br.edu.univas.previsaotempo.web.WebTaskWeather;

public class MyFragment extends Fragment {

    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    private String city;
    private TextView cidade;

    public static final MyFragment newInstance(String message) {

        MyFragment f = new MyFragment();
        Bundle bdl = new Bundle(1);
        bdl.putString(EXTRA_MESSAGE, message);
        f.setArguments(bdl);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String message = getArguments().getString(EXTRA_MESSAGE);
        View v = inflater.inflate(R.layout.activity_my_fragment, container, false);
//        TextView messageTextView = (TextView)v.findViewById(R.id.textView);
//        messageTextView.setText(message);


        cidade = (TextView) v.findViewById(R.id.cidade_fragment);
        TextView temperatura = (TextView) v.findViewById(R.id.temperatura);

        WebTaskWeather task = new WebTaskWeather(this.getContext(), message, cidade, temperatura);
        task.execute();

        viewDetailConfigure(v);
        return v;

    }

    private void viewDetailConfigure(View v) {

        Button detailBtn = (Button) v.findViewById(R.id.viewDetail);
        detailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDetail();
            }
        });
    }

    private void goToDetail() {

        Intent intent = new Intent(this.getContext(), PageDetails.class);
        intent.putExtra("CITY", cidade.getText().toString());
        startActivity(intent);
    }


}
