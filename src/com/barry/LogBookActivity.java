package com.barry;

import com.barry.domain.Mark;
import com.barry.domain.service.IMarkService;
import com.barry.domain.service.MarkService;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LogBookActivity extends Activity {
	private EditText markDetailsEditText;
	private Button markButton;
	private IMarkService markService;
	
	private Mark mark;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        markService = new MarkService();
        setContentView(R.layout.main);
        
        markDetailsEditText = (EditText)findViewById(R.id.markDescription);
        markButton = (Button)findViewById(R.id.markButton);
        
        markButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String description = markDetailsEditText.getText().toString();
				Log.d(LogBookActivity.class.getName(),"text:" + markDetailsEditText.getText().toString());
				mark = new Mark();
				mark.description = description;
				markService.storeMark(mark);
				
				
			}
		});
        
        
        
    }
    
    
    
}