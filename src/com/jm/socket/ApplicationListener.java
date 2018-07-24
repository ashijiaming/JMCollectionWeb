package com.jm.socket;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ApplicationListener
 */
@WebListener
public class ApplicationListener implements ServletContextListener {
    /**
     * Default constructor. 
     */
    public ApplicationListener() {
        // TODO Auto-generated constructor stub
    }
    
    
	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 

    	   LogUtil.i("ApplicationListener", "开启全局监听");
    	   //ChatServer.startServer();
    	   new SocketThread().start();
    	
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	LogUtil.i("ApplicationListener", "全局监听销毁");      
        // TODO Auto-generated method stub
    }


	
}
