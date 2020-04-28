package com.example.hairstylingreservation;

import android.app.DatePickerDialog;
import android.app.FragmentManager;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.Calendar;

public class ReservationFragment extends Fragment {

    private int year, month, day, hour, min;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_reservation,container,false);

        //afiseaza caseta de selectie a datee
        final TextView dataDisp = view.findViewById(R.id.date);
        dataDisp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Calendar cal = Calendar.getInstance();
                year = cal.get(Calendar.YEAR);
                month = cal.get(Calendar.MONTH);
                day = cal.get(Calendar.DAY_OF_MONTH);
//                Toast.makeText(view.getContext(),"sadas",Toast.LENGTH_SHORT).show();
                final DatePickerDialog dp = new DatePickerDialog(getContext(),new DatePickerDialog.OnDateSetListener(){
                    public void onDateSet(DatePicker datePicker, int year, int month, int day){
                        String s = "data:"+day+"/"+month+"/"+year;
                        dataDisp.setText(s);
                    }
                },day,month, year);
                dp.show();
            }
        });

        //afisare caseta de selectaree a orei
        final TextView timeDisp = view.findViewById(R.id.time);
            timeDisp.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Calendar c = Calendar.getInstance();
                    hour = c.get(Calendar.HOUR_OF_DAY);
                    min = c.get(Calendar.MINUTE);

                    TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            String s = "ora: "+ hour +":"+ minute;
                            timeDisp.setText(s);
                            //Toast.makeText(getContext(), " g"+ hour + "g" + minute ,Toast.LENGTH_SHORT).show();
                        }
                    },hour, min, true);
                    timePickerDialog.show();//lanseaza afisarea timepicker-ului
                 }
            });
        // butonul de continuare
        Button contBtn = view.findViewById(R.id.button);

        contBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

//              Intent i1 = new Intent(getContext(), AboutFragment.class);

                //redirectionare la view-ul de selectie a frizurii
                //+trimite datele introduse aici mai departe
            }
        });

        return view;
    }
}
