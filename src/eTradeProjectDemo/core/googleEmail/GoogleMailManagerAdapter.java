package eTradeProjectDemo.core.googleEmail;

import eTradeProjectDemo.core.EmailService;
import eTradeProjectDemo.googleMail.GoogleMailManager;

public class GoogleMailManagerAdapter implements EmailService{

	private GoogleMailManager googleMailManager;

	public GoogleMailManagerAdapter() {
		super();
		this.googleMailManager = new GoogleMailManager();
	}

	@Override
	public void send(String email, String message) {
		googleMailManager.send(email, message);
		
	}


}
