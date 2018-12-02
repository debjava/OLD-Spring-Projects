package com.ddlab.rnd.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.ddlab.rnd.web.beans.App;
import com.ddlab.rnd.web.beans.User;
import com.ddlab.rnd.web.beans.Users;

public class XMLUtil {
	private static final String FILE_PATH = "E:/luna-ws-2013/springmvcweb6/data/app.xml";

	public static void saveUserInfo(User user1) {

		File file = new File(FILE_PATH);
		App app = null;
		if (file.exists()) {
			// Read the xml file
			try {
				JAXBContext jctx = JAXBContext.newInstance(App.class);
				Unmarshaller unmarshaller = jctx.createUnmarshaller();
				app = (App) unmarshaller.unmarshal(file);
				app.getUsers().getUser().add(user1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// Create a new File
			app = new App();
			app.setName("Application for spring training");
			List<User> userList = new ArrayList<User>();
			userList.add(user1);
			Users users = new Users();
			users.setUser(userList);
			app.setUsers(users);
		}
		OutputStream outStream = null;
		try {
			outStream = new FileOutputStream(file);
			JAXBContext jctx = JAXBContext.newInstance(App.class);
			Marshaller marshaller = jctx.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(app, outStream);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (outStream != null) {
					outStream.flush();
					outStream.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public static List<User> getUserInfoList() throws Exception {
		List<User> userList = new ArrayList<User>();
		try {
			File file = new File(FILE_PATH);
			if( !file.exists() ) throw new Exception("User detail does not exist");
			JAXBContext jctx = JAXBContext.newInstance(App.class);
			Unmarshaller unmarshaller = jctx.createUnmarshaller();
			App app = (App) unmarshaller.unmarshal(file);
			userList = app.getUsers().getUser();
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return userList;
	}

}
