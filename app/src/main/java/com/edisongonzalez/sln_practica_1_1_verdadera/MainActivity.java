package com.edisongonzalez.sln_practica_1_1_verdadera;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.math.*; // SI SE PUEDE UTILIZAR MATH EN ANDROID

public class MainActivity extends AppCompatActivity {

    private RadioButton rcuadro, rcirculo, rtriangulo, rcubo;
    private ImageView ielemento;
    private TextView tladoa, tladob, tladoc, tresultado;
    private EditText eladoa, eladob, eladoc;
    //private Button bcalcular;
    private String s_eladoa="", s_eladob="", s_eladoc="";
    private double d_eladoa=0, d_eladob=0, d_eladoc=0, d_perimetro=0, d_area=0, d_semiperimetro=0, d_volumen=0;
    private RadioGroup opcionesCliente;
    public int y_n=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcuadro = (RadioButton) findViewById(R.id.rbcuadro_id);
        rcirculo = (RadioButton) findViewById(R.id.rbcirculo_id);
        rtriangulo = (RadioButton) findViewById(R.id.rbtriangulo_id);
        rcubo = (RadioButton) findViewById(R.id.rbcubo_id);
        ielemento = (ImageView) findViewById(R.id.ivelemento_id);
        tladoa = (TextView) findViewById(R.id.tvladoa_id);
        tladob = (TextView) findViewById(R.id.tvladob_id);
        tladoc = (TextView) findViewById(R.id.tvladoc_id);
        tresultado = (TextView) findViewById(R.id.tvresultado_id);
        eladoa = (EditText) findViewById(R.id.etladoa_id);
        eladob = (EditText) findViewById(R.id.etladob_id);
        eladoc = (EditText) findViewById(R.id.etladoc_id);
        //bcalcular = (Button) findViewById(R.id.bcalcular_id);
        //opcionesCliente = (RadioGroup) findViewById(R.id.rgfigura_id);
        /**
        opcionesCliente.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(y_n==1){
                    switch (checkedId){
                        case R.id.rbcuadro_id:
                            tresultado.setText("a");
                            y_n=0;
                            break;
                        case R.id.rbcirculo_id:
                            tresultado.setText("b");
                            y_n=0;
                            break;
                    }
                }
            }
        });
        **/
    }

    /**
    private void function_cal(View view2) {
        boolean marcado = ((RadioButton) view2).isChecked();

        switch (view2.getId()) {
            case R.id.rbcuadro_id:
                if (marcado) {
                    tresultado.setText("a");
                }
                break;
            case R.id.rbcirculo_id:
                if (marcado) {
                    tresultado.setText("b");
                }
                break;
            case R.id.rbtriangulo_id:
                if (marcado) {
                    tresultado.setText("c");
                }
                break;
            case R.id.rbcubo_id:
                if (marcado) {
                    tresultado.setText("d");
                }
                break;
            default:
                break;
        }
    }
    **/

    public void function_sel(View view) {
        boolean marcado = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rbcuadro_id:
                if (marcado) {
                    ielemento.setImageResource(R.drawable.cuadrado);
                    control_editext_textview_result(1);
                }
                break;
            case R.id.rbcirculo_id:
                if (marcado) {
                    ielemento.setImageResource(R.drawable.circulo);
                    control_editext_textview_result(2);
                }
                break;
            case R.id.rbtriangulo_id:
                if (marcado) {
                    ielemento.setImageResource(R.drawable.triangulo);
                    control_editext_textview_result(3);
                }
                break;
            case R.id.rbcubo_id:
                if (marcado) {
                    ielemento.setImageResource(R.drawable.cubo);
                    control_editext_textview_result(4);
                }
                break;
            default:
                break;
        }
    }

    private void control_editext_textview_result(int i) {
        switch(i){
            case 1:
                tladoa.setText("Ingrese lado");
                tladoa.setVisibility(View.VISIBLE);
                eladoa.setVisibility(View.VISIBLE);
                tladob.setVisibility(View.INVISIBLE);
                eladob.setVisibility(View.INVISIBLE);
                tladoc.setVisibility(View.INVISIBLE);
                eladoc.setVisibility(View.INVISIBLE);
                tresultado.setText("");
                y_n = 1;
                break;
            case 2:
                tladoa.setText("Ingrese el radio");
                tladoa.setVisibility(View.VISIBLE);
                eladoa.setVisibility(View.VISIBLE);
                tladob.setVisibility(View.INVISIBLE);
                eladob.setVisibility(View.INVISIBLE);
                tladoc.setVisibility(View.INVISIBLE);
                eladoc.setVisibility(View.INVISIBLE);
                tresultado.setText("");
                y_n = 2;
                break;
            case 3:
                tladoa.setText("Ingrese lado 1");
                tladoa.setVisibility(View.VISIBLE);
                eladoa.setVisibility(View.VISIBLE);
                tladob.setText("Ingrese lado 2");
                tladob.setVisibility(View.VISIBLE);
                eladob.setVisibility(View.VISIBLE);
                tladoc.setText("Ingrese lado 3");
                tladoc.setVisibility(View.VISIBLE);
                eladoc.setVisibility(View.VISIBLE);
                tresultado.setText("");
                y_n = 3;
                break;
            case 4:
                tladoa.setText("Ingrese lado");
                tladoa.setVisibility(View.VISIBLE);
                eladoa.setVisibility(View.VISIBLE);
                tladob.setVisibility(View.INVISIBLE);
                eladob.setVisibility(View.INVISIBLE);
                tladoc.setVisibility(View.INVISIBLE);
                eladoc.setVisibility(View.INVISIBLE);
                tresultado.setText("");
                y_n = 4;
                break;
            default:
                tresultado.setText("Nada");
                break;
        }
    }

    public void press_button(View view) {
        switch (y_n) {
            case 1:
                s_eladoa = eladoa.getText().toString();
                if(s_eladoa.isEmpty()){
                    d_eladoa = 0;
                }
                else{
                    d_eladoa = Double.parseDouble(s_eladoa);
                }
                d_perimetro = 4*d_eladoa;
                d_area = Math.pow(d_eladoa,2);
                tresultado.setText("El resultado es:"+
                                    "\n     - Perímetro: "+d_perimetro+
                                    "\n     - Área: "+d_area);
                break;
            case 2:
                s_eladoa = eladoa.getText().toString();
                if(s_eladoa.isEmpty()){
                    d_eladoa = 0;
                }
                else{
                    d_eladoa = Double.parseDouble(s_eladoa);
                }
                d_perimetro = (2*(Math.PI)*d_eladoa);
                d_area = (Math.PI*(Math.pow(d_eladoa,2)));
                tresultado.setText("El resultado es:"+
                        "\n     - Perímetro: "+d_perimetro+
                        "\n     - Área: "+d_area);
                break;
            case 3:
                s_eladoa = eladoa.getText().toString();
                s_eladob = eladob.getText().toString();
                s_eladoc = eladoc.getText().toString();
                if(s_eladoa.isEmpty()){
                    d_eladoa = 0;
                    tresultado.setText("No hay triángulos, sin tres lados");
                    break;
                }
                else{
                    d_eladoa = Double.parseDouble(s_eladoa);
                }
                if(s_eladob.isEmpty()){
                    d_eladob = 0;
                    tresultado.setText("No hay triángulos, sin tres lados");
                    break;
                }
                else{
                    d_eladob = Double.parseDouble(s_eladob);
                }
                if(s_eladoc.isEmpty()){
                    d_eladoc = 0;
                    tresultado.setText("No hay triángulos, sin tres lados");
                    break;
                }
                else{
                    d_eladoc = Double.parseDouble(s_eladoc);
                }
                d_perimetro = d_eladoa + d_eladob + d_eladoc;
                d_semiperimetro = d_perimetro/2;
                d_area = (Math.sqrt((d_semiperimetro*(d_semiperimetro-d_eladoa)*(d_semiperimetro-d_eladob)*(d_semiperimetro-d_eladoc))));
                tresultado.setText("El resultado es:"+
                        "\n     - Perímetro: "+d_perimetro+
                        "\n     - Área: "+d_area);
                break;
            case 4:
                s_eladoa = eladoa.getText().toString();
                if(s_eladoa.isEmpty()){
                    d_eladoa = 0;
                }
                else{
                    d_eladoa = Double.parseDouble(s_eladoa);
                }
                d_area = (6*(Math.pow(d_eladoa,2)));
                d_volumen = (Math.pow(d_eladoa,3));
                tresultado.setText("El resultado es:"+
                        "\n     - Área Superficial: "+d_area+
                        "\n     - Volumen: "+d_volumen);
                break;
            default:
                tresultado.setText("");
                break;
        }
    }
}
