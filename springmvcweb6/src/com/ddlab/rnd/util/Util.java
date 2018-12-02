package com.ddlab.rnd.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.ddlab.rnd.web.beans.App;
import com.ddlab.rnd.web.beans.User;
import com.ddlab.rnd.web.beans.Users;

public class Util {

	private static final String FILE_PATH = "E:/luna-ws-2013/springmvcweb6/data/app.xml";
	private static final String TXT_FILE_PATH = "E:/luna-ws-2013/springmvcweb6/data/user.txt";
	private Lock lock = new ReentrantLock(true);

	private void createXmlFile(App app) {
		OutputStream outStream = null;
		JAXBContext jctx = null;
		synchronized (app) {
			try {
				outStream = new FileOutputStream(FILE_PATH);
				jctx = JAXBContext.newInstance(App.class);
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
		
	}

	public void saveUserInfo(User user1) {
		// OutputStream outStream = null;
		JAXBContext jctx = null;
		App app = null;
		// Check whether file exists or not
		try {
			lock.lock();
			File file = new File(FILE_PATH);
			if (file.exists()) {
				// Read the XML file and add the user
				try {
					jctx = JAXBContext.newInstance(App.class);
					Unmarshaller unmarshaller = jctx.createUnmarshaller();
					app = (App) unmarshaller.unmarshal(file);
					app.getUsers().getUser().add(user1);
					createXmlFile(app);
				} catch (Exception e) {
					System.out
					.println("File exists, but error in reading file .....");
					System.out.println("Going to create a new user ..........");
					e.printStackTrace();
					createNewUser(user1);
				}
			} else {
				// Create a new File
				createNewUser(user1);
			}
			

		} finally {
			lock.unlock();
		}
	}
	
	private void createNewUser(User user1) {
		
		App app = new App();
		app.setName("Application for spring training");
		List<User> userList = new ArrayList<User>();
		userList.add(user1);
		Users users = new Users();
		users.setUser(userList);
		app.setUsers(users);
		createXmlFile(app);
	}
	
//	public synchronized void saveUserDetails(User user) {
	public void saveUserDetails(User user) {
		lock.lock();
//		lock.tryLock();
//		synchronized (user) {
			OutputStream out = null;
			try {
				out = new FileOutputStream(TXT_FILE_PATH,true);
				String data = user.toString()+"\n";
				out.write(data.getBytes());
//				out.write("\n".getBytes());
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					if (out != null) {
						out.flush();
						out.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				lock.unlock();
			}
//		}
		
		
	}
	
	public void saveUserDetailsFaulty(User user) {
			OutputStream out = null;
			try {
				out = new FileOutputStream(TXT_FILE_PATH,true);
				String data = user.toString()+"\n";
				out.write(data.getBytes());
//				out.write("\n".getBytes());
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					if (out != null) {
						out.flush();
						out.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
//		}
		
		
	}
}
