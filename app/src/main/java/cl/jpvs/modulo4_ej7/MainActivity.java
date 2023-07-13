package cl.jpvs.modulo4_ej7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.Callable;

import cl.jpvs.modulo4_ej7.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;   //paso1
    private long leerFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityMainBinding.inflate(getLayoutInflater());     // paso2 :
        setContentView(binding.getRoot());
        ImageView imageView = (ImageView) findViewById(R.id.my_image_view);
        Glide.with(this).load("https://media.licdn.com/dms/image/D4E16AQEmXc3EIov-uA/profile-displaybackgroundimage-shrink_350_1400/0/1687924764356?e=1694649600&v=beta&t=pIehCc9piot3cm3JtsAGgBwYsrdgcwiO03zWpDXON7A").into(imageView);

        //
        // paso3 ;



        binding.switchTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.switchTheme.isChecked()) {
                    setDayNight(0);
                    Toast.makeText(getBaseContext(), "Enable Dark Mode", Toast.LENGTH_SHORT).show();
                } else {
                    setDayNight(1);
                    Toast.makeText(getBaseContext(), "Enable Light Mode", Toast.LENGTH_SHORT).show();
                }
            }

            });

        binding.calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, dayOfMonth);

                leerFecha = calendar.getTimeInMillis();


                    }
                });
        binding.btnFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String selecionFecha = formatoFecha(leerFecha);
                Toast.makeText(MainActivity.this,"Fecha selecionada: " + selecionFecha, Toast.LENGTH_SHORT).show();

                binding.tvTitulo.setText("Fecha selecionada: "+selecionFecha);
            }
        });
            }

    private String formatoFecha(long leerFecha) {
        return new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date(leerFecha));
    }

    private void setDayNight(int i) {

        if(i==0){
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else{
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}





