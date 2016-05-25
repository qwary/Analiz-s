//package events;
//
//import java.util.ArrayList;
//
//import gui.SearchEventGUI;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
////import lt.ktu.formbackend.model.Form;
////import lt.ktu.formbackend.model.FormsContainer;
////import lt.ktu.project.client.SearchParameters;
////import lt.ktu.project.client.ServerCommunication;
////import lt.ktu.projektas.AlertGUI;
////import lt.ktu.projektas.LoadingGUI;
////import lt.ktu.projektas.LoginGUI;
//
//public class onSearch implements EventHandler<ActionEvent>{
//
//
//
//
//	private SearchEventGUI window;
//	
//	public onSearch(SearchEventGUI window)
//	{
//		this.window = window;
//	}
//	
//	
//	@Override
//	public void handle(ActionEvent arg0) {
//		
//		if(window.getStations().length() == 0)
//		{
//			AlertGUI.show("FIll in your username");
//			return;
//		}
//		if(window.getPassword().length() == 0)
//		{
//			AlertGUI.show("Fill in your password");
//			return;
//		}
//		
//				
//		Runnable run = new Runnable() {
//			@Override
//			public void run() {
//				
//						//Kodas, kuris vykdomas kol rodomas loading langas, ir jam pasibaigus langas iðjungiamas	
//				try{
//					ServerCommunication.open(window.getUsername(), window.getPassword());
//					ServerCommunication.LogInUser(window.getUsername(), window.getPassword());
//					window.getMain().showLoggedUserMenuBar();
//					window.getMain().getFormList().getPublicList().getItems().clear();
//					window.getMain().getFormList().getPrivateList().getItems().clear();
//					FormsContainer formC = ServerCommunication.getForms(new SearchParameters("", "", "", 0, "", "", 0, "", ""));
//					ArrayList<Form> forms = formC.getForms();
//					window.getMain().getFormList().addForms(forms);
//					//if(forms.size()>0)
//						//tabs.openForm(new GUIForm(forms.get(0)), ServerCommunication.getAnswer(Long.toString(forms.get(0).getId())));
//					if(window.getMain().getFormList().getPublicList().getItems().size() > 0){
//						window.getMain().getFormList().getPublicList().getSelectionModel().select(0);
//						window.getMain().getFormList().getPublicList().getFocusModel().focus(0);
//					}else if(window.getMain().getFormList().getPrivateList().getItems().size() > 0){
//						window.getMain().getFormList().getPrivateList().getSelectionModel().select(0);
//						window.getMain().getFormList().getPrivateList().getFocusModel().focus(0);
//					}
//				}
//				catch(Exception e){
//					AlertGUI.show("Could not connect to server");
//					return;
//				}
//			}
//		};
//		LoadingGUI.show(run); // Kol bus atidarytas langas, kodas po ðios eilutës nevyks kol langas nebus uþdarytas, ar jam duotas kodas pabaigtas
//		
//		
//		window.close();
//		
//	}
//	
//}