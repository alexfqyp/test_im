package com.test.testim;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
	private ListView list;
	private Button send;
	private ToggleButton toggle;
	private EditText edit;
	private List<MessageVo> meList = new ArrayList<MessageVo>();
	private MessageAdapter messageAdapter = new MessageAdapter(this, meList);;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		initWidget();
		list.setAdapter(messageAdapter);
		send.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String content = edit.getText().toString();
				String sendContent;
				SimpleDateFormat df = new SimpleDateFormat("MM-dd HH:mm:ss");
				String time = df.format(new Date()).toString();
				System.out.println("time--------" + time);
				if (content != null
						&& (sendContent = content.trim().replaceAll("\r", "").replaceAll("\t", "").replaceAll("\n", "")
								.replaceAll("\f", "")) != "")
				{
					if(toggle.isChecked())
					{
						meList.add(new MessageVo(MessageVo.MESSAGE_FROM, sendContent, time));
					}
					else
					{
						meList.add(new MessageVo(MessageVo.MESSAGE_TO, sendContent, time));
					}
					
					messageAdapter.notifyDataSetChanged();
				}
					edit.setText("");
			}
		});
	}
	
	public void initWidget()
	{
		list = (ListView)findViewById(R.id.list);
		send = (Button)findViewById(R.id.send);
		edit = (EditText)findViewById(R.id.edit);
		toggle = (ToggleButton)findViewById(R.id.toggle);
	}
	/**
	 * 消息设置
	 */
//	private void sendMessage(int direction,String content)
//	{
//		SimpleDateFormat df = new SimpleDateFormat("MM-dd HH:mm:ss");
//		String time = df.format(new Date());
//		if(direction == MessageVo.MESSAGE_FROM)
//		{
//			meList.add(new MessageVo(MessageVo.MESSAGE_FROM, content, time));
//		}
//		else
//		{
//			meList.add(new MessageVo(MessageVo.MESSAGE_TO, content, time));
//		}
//		messageAdapter.notifyDataSetChanged();
//		
//	}
//	
}
