package edu.ben.util;

import java.util.List;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import edu.ben.DAOs.AssignmentDAO;
import edu.ben.DAOs.ReminderDAO;
import edu.ben.models.Assignment;
import edu.ben.models.Reminder;

public class NotificationRunner {

	public static void main(String[] args) {

		final List<Reminder> reminders = ReminderDAO.getActiveReminders();

		Timer timer = new Timer();

		for (final Reminder r : reminders) {
			if (r.getDelay() > 0) {
				timer.schedule(new TimerTask() {
					@Override
					public void run() {
						if (r.getType() == Reminder.EMAIL) {
							Assignment assignmnt = AssignmentDAO.findByAssignmentID(r.getAssignmentID());
							sendEmail(r, assignmnt);
							System.out.println("EMAIL SENT");
						} else {
							sendSMS(r);
						}
					}
				}, r.getDelay());
			}
		}
	}

	public static void sendEmail(Reminder rem, Assignment a) {

		final String username = "assignmenttracker123@gmail.com";
		final String password = "assignment";

		String mes = a.getName() + " due at " + a.getDue().toString() + "!";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(rem.getEmail()));
			message.setSubject("Assignment Due Soon!");
			message.setText(mes);

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	private static void sendSMS(Reminder rem) {

	}
}