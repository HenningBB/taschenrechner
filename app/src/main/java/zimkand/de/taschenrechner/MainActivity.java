package zimkand.de.taschenrechner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener{
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        Button btnRechnen = findViewById(R.id.btnRechen);
        btnRechnen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText eingabe1 = findViewById(R.id.zahl1);
                EditText eingabe2 = findViewById(R.id.zahl2);
                if (eingabe1.length() == 0 || eingabe2.length() == 0) {
                    builder.setMessage(getString(R.string.zahlHinweis));
                    AlertDialog dialog = builder.create();
                    dialog.show();
                    return;
                }
                String eZahl = eingabe1.getText().toString();
                String zZahl = eingabe2.getText().toString();
                double zahl1 = Double.parseDouble(eZahl);
                double zahl2 = Double.parseDouble(zZahl);
                double zahlE;
                switch (text){
                    case "+":
                        zahlE=zahl1+zahl2;
                        break;
                    case "-":
                        zahlE=zahl1-zahl2;
                        break;
                    case "*":
                        zahlE=zahl1*zahl2;
                        break;
                    case "/":
                        zahlE=zahl1/zahl2;
                        break;
                    default:
                        zahlE=0;
                        break;
                }

                TextView tv = findViewById(R.id.tvErgebins);
                tv.setText(getString(R.string.ergebnis) + " " + zahlE);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        if(position != 0){
             text = ((TextView)view).getText().toString();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}