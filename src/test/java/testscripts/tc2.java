package testscripts;

import java.io.IOException;
import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

import org.openqa.selenium.virtualauthenticator.VirtualAuthenticatorOptions.Transport;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class tc2 implements ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        // Do nothing on suite start
    }

    @Override
    public void onFinish(ISuite suite) {
        // Send email after suite execution completes
        sendEmailWithReport("recipient@example.com", "Test Report", "Please find attached the TestNG report.");
    }

    private void sendEmailWithReport(String recipient, String subject, String body) {
        final String username = "your_email@example.com";
        final String password = "your_email_password";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.example.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // Create a new email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);

            // Attach the TestNG report
            // Replace "path_to_report" with the actual path to your TestNG report file
            String reportPath = "path_to_report"; // e.g., "C:/path/to/your/report.html"
            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile(reportPath);

            // Create Multipart object to add the email body and attachment
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(attachmentPart);

            // Set the email body
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText(body);

            multipart.addBodyPart(textPart);
            message.setContent(multipart);

            // Send the email
            Transport.send(message);
            System.out.println("Email sent successfully.");

        } catch (MessagingException | IOException e) {
            e.printStackTrace(); // Handle the exception appropriately, log it, or rethrow it
        }
    }
}
