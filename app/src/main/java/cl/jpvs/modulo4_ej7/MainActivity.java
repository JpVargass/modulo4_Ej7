package cl.jpvs.modulo4_ej7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Toast;

import cl.jpvs.modulo4_ej7.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;   //paso1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityMainBinding.inflate(getLayoutInflater());     // paso2 :
        setContentView(binding.getRoot());
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


