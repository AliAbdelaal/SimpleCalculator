package com.Ali.simplecalculator;

import android.app.Activity;
import android.widget.TextView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;	
import android.widget.Spinner;
import android.widget.Toast;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;



public class SimpleCalculator_Main extends Activity {

	Spinner spn ; 
	TextView txt;
	Button btn ;
	EditText n1 , n2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calculator__main);
        spn = (Spinner) findViewById(R.id.spinner1);
        txt = (TextView) findViewById(R.id.textView2);
        btn = (Button) findViewById(R.id.button1);
        n1 = (EditText) findViewById(R.id.editText1);
        n2 = (EditText) findViewById(R.id.editText2);
       
        btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				calc();
				hideKey();
			}
		});
        
        n2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				calc();
				hideKey();
				
			}
		});
    }
    protected void clear(){
    	//TO DO : clear
    	n1.setText("");
    	n2.setText("");
    	txt.setText("");
    }

    protected void hideKey(){
    	//TO DO : hideKeyboard
    	InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(txt.getWindowToken(), 0);
    }
    protected boolean isEmpty(){
    	String first = n1.getText().toString().trim();
    	String second= n2.getText().toString().trim();
    	if(first.equals("")||second.equals("")) return true;
    	else return false ;
    }

	protected void calc(){
		
		if(isEmpty())
	    Toast.makeText(getApplicationContext(),"Please enter ur numbers !", Toast.LENGTH_SHORT).show();
		else {
			double d1 = Double.parseDouble(n1.getText().toString().trim());
			double d2 = Double.parseDouble(n2.getText().toString().trim());
			String op = spn.getSelectedItem().toString();
			double result=0;
			if(op.equals("+"))  result = d1 + d2 ;  
			else if(op.equals("-")) result = d1 - d2 ;
			else if (op.equals("*")) result = d1 * d2 ;
			else if (op.equals("/")){
				if(d2==0){ Toast.makeText(getApplicationContext(), "can't divide by zero", Toast.LENGTH_SHORT).show();
				return;}
				else result = d1 / d2 ;
			}
		
			
		//String ans = String.format("%1.2f %s %1.2f = %1.2f ", d1 , d2 , op , result);
		
		String ans = String.format("%1.2f %s %1.2f = %1.2f ", d1 , op, d2  , result);
		txt.setText(ans);
		//txt.setText(d1+ " " + op + " " + d2 + " = " + result);
	
	}}
}
