package com.example.wheresmystuff.View;

import android.content.Context;

public interface ILoginView {

	
	void notify_of_error(String error_message);
	<T> void call_intent(Class<T> c);
	
}
