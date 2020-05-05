package airline;



import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mail {

    public static void main(String[] args) {

       
        String to = "replace sender mail";

        
        String from = "replace revicer mail";

        
        String host = "smtp.gmail.com";

       
        Properties properties = System.getProperties();

        
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("sender mail", "pwd");

            }

        });

       
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Welcome To Stark Airlines!");
            MimeMultipart multipart = new MimeMultipart("related");
            // Now set the actual message
            BodyPart messageBodyPart = new MimeBodyPart();
            String htmlText = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" + 
            		"<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" + 
            		"<head>\n" + 
            		"	<!--[if gte mso 9]>\n" + 
            		"	<xml>\n" + 
            		"		<o:OfficeDocumentSettings>\n" + 
            		"		<o:AllowPNG/>\n" + 
            		"		<o:PixelsPerInch>96</o:PixelsPerInch>\n" + 
            		"		</o:OfficeDocumentSettings>\n" + 
            		"	</xml>\n" + 
            		"	<![endif]-->\n" + 
            		"	<meta http-equiv=\"Content-type\" content=\"text/html; charset=utf-8\" />\n" + 
            		"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\" />\n" + 
            		"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n" + 
            		"	<meta name=\"format-detection\" content=\"date=no\" />\n" + 
            		"	<meta name=\"format-detection\" content=\"address=no\" />\n" + 
            		"	<meta name=\"format-detection\" content=\"telephone=no\" />\n" + 
            		"	<meta name=\"x-apple-disable-message-reformatting\" />\n" + 
            		"    <!--[if !mso]><!-->\n" + 
            		"	<link href=\"https://fonts.googleapis.com/css?family=Muli:400,400i,700,700i\" rel=\"stylesheet\" />\n" + 
            		"    <!--<![endif]-->\n" + 
            		"	<title>Email Template</title>\n" + 
            		"	<!--[if gte mso 9]>\n" + 
            		"	<style type=\"text/css\" media=\"all\">\n" + 
            		"		sup { font-size: 100% !important; }\n" + 
            		"	</style>\n" + 
            		"	<![endif]-->\n" + 
            		"	\n" + 
            		"\n" + 
            		"	<style type=\"text/css\" media=\"screen\">\n" + 
            		"		/* Linked Styles */\n" + 
            		"		body { padding:0 !important; margin:0 !important; display:block !important; min-width:100% !important; width:100% !important; background:#FFFFFF; -webkit-text-size-adjust:none }\n" + 
            		"		a { color:#66c7ff; text-decoration:none }\n" + 
            		"		p { padding:0 !important; margin:0 !important } \n" + 
            		"		img { -ms-interpolation-mode: bicubic; /* Allow smoother rendering of resized image in Internet Explorer */ }\n" + 
            		"		.mcnPreviewText { display: none !important; }\n" + 
            		"\n" + 
            		"				\n" + 
            		"		/* Mobile styles */\n" + 
            		"		@media only screen and (max-device-width: 480px), only screen and (max-width: 480px) {\n" + 
            		"			.mobile-shell { width: 100% !important; min-width: 100% !important; }\n" + 
            		"			.bg { background-size: 100% auto !important; -webkit-background-size: 100% auto !important; }\n" + 
            		"			\n" + 
            		"			.text-header,\n" + 
            		"			.m-center { text-align: center !important; }\n" + 
            		"			\n" + 
            		"			.center { margin: 0 auto !important; }\n" + 
            		"			.container { padding: 20px 10px !important }\n" + 
            		"			\n" + 
            		"			.td { width: 100% !important; min-width: 100% !important; }\n" + 
            		"\n" + 
            		"			.m-br-15 { height: 15px !important; }\n" + 
            		"			.p30-15 { padding: 30px 15px !important; }\n" + 
            		"\n" + 
            		"			.m-td,\n" + 
            		"			.m-hide { display: none !important; width: 0 !important; height: 0 !important; font-size: 0 !important; line-height: 0 !important; min-height: 0 !important; }\n" + 
            		"\n" + 
            		"			.m-block { display: block !important; }\n" + 
            		"\n" + 
            		"			.fluid-img img { width: 100% !important; max-width: 100% !important; height: auto !important; }\n" + 
            		"\n" + 
            		"			.column,\n" + 
            		"			.column-top,\n" + 
            		"			.column-empty,\n" + 
            		"			.column-empty2,\n" + 
            		"			.column-dir-top { float: left !important; width: 100% !important; display: block !important; }\n" + 
            		"\n" + 
            		"			.column-empty { padding-bottom: 10px !important; }\n" + 
            		"			.column-empty2 { padding-bottom: 30px !important; }\n" + 
            		"\n" + 
            		"			.content-spacing { width: 15px !important; }\n" + 
            		"		}\n" + 
            		"	</style>\n" + 
            		"</head>\n" + 
            		"<body class=\"body\" style=\"padding:0 !important; margin:0 !important; display:block !important; min-width:100% !important; width:100% !important; background:#FFFFFF; -webkit-text-size-adjust:none;\">\n" + 
            		"	<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#001736\">\n" + 
            		"		<tr>\n" + 
            		"			<td align=\"center\" valign=\"top\">\n" + 
            		"				<table width=\"650\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"mobile-shell\">\n" + 
            		"					<tr>\n" + 
            		"						<td class=\"td container\" style=\"width:650px; min-width:650px; font-size:0pt; line-height:0pt; margin:0; font-weight:normal; padding:55px 0px;\">\n" + 
            		"							<!-- Header -->\n" + 
            		"							<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" + 
            		"								<tr>\n" + 
            		"									<td class=\"p30-15\" style=\"padding: 0px 30px 30px 30px;\">\n" + 
            		"										<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" + 
            		"											<tr>\n" + 
            		"												<th class=\"column-top\" width=\"145\" style=\"font-size:0pt; line-height:0pt; padding:0; margin:0; font-weight:normal; vertical-align:top;\">\n" + 
            		"													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" + 
            		"														<tr>\n" + 
            		"															<td class=\"img m-center\" style=\"font-size:0pt; line-height:0pt; text-align:left;\"></td>\n" + 
            		"														</tr>\n" + 
            		"													</table>\n" + 
            		"												</th>\n" + 
            		"												<th class=\"column-empty\" width=\"1\" style=\"font-size:0pt; line-height:0pt; padding:0; margin:0; font-weight:normal; vertical-align:top;\"></th>\n" + 
            		"												<th class=\"column\" style=\"font-size:0pt; line-height:0pt; padding:0; margin:0; font-weight:normal;\">\n" + 
            		"													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" + 
            		"														<tr>\n" + 
            		"														\n" + 
            		"														</tr>\n" + 
            		"													</table>\n" + 
            		"												</th>\n" + 
            		"											</tr>\n" + 
            		"										</table>\n" + 
            		"									</td>\n" + 
            		"								</tr>\n" + 
            		"							</table>\n" + 
            		"							<!-- END Header -->\n" + 
            		"\n" + 
            		"							<!-- Intro -->\n" + 
            		"							<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" + 
            		"								<tr>\n" + 
            		"									<td style=\"padding-bottom: 10px;\">\n" + 
            		"										<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" + 
            		"											<tr>\n" + 
            		"												<td class=\"tbrr p30-15\" style=\"padding: 60px 30px; border-radius:26px 26px 0px 0px;\" bgcolor=\"#12325c\">\n" + 
            		"													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" + 
            		"														<tr>\n" + 
            		"															<td class=\"h1 pb25\" style=\"color:#ffffff; font-family:'Muli', Arial,sans-serif; font-size:40px; line-height:46px; text-align:center; padding-bottom:25px;\">Welcome,Stark Airlines</td>\n" + 
            		"														</tr>\n" + 
            		"														<tr>\n" + 
            		"															<td class=\"text-center pb25\" style=\"color:#c1cddc; font-family:'Muli', Arial,sans-serif; font-size:16px; line-height:30px; text-align:center; padding-bottom:25px;\">Every year, nearly 200 million travelers trust Stark Airlines to get them where they are going. But to us, travel is about more than just bringing people to a place. It about bringing people together.<span class=\"m-hide\"><br /></span></td>\n" + 
            		"														</tr>\n" + 
            		"														<!-- Button -->\n" + 
            		"														<tr>\n" + 
            		"															<td align=\"center\">\n" + 
            		"																<table class=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"text-align:center;\">\n" + 
            		"																	<\n" + 
            		"																</table>\n" + 
            		"															</td>\n" + 
            		"														</tr>\n" + 
            		"														<!-- END Button -->\n" + 
            		"													</table>\n" + 
            		"												</td>\n" + 
            		"											</tr>\n" + 
            		"										</table>\n" + 
            		"									</td>\n" + 
            		"								</tr>\n" + 
            		"							</table>\n" + 
            		"							<!-- END Intro -->\n" + 
            		"\n" + 
            		"							<!-- Article / Full Width Image + Title + Copy + Button -->\n" + 
            		"							<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" + 
            		"								<tr>\n" + 
            		"									<td style=\"padding-bottom: 10px;\">\n" + 
            		"										<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#0e264b\">\n" + 
            		"											<tr>\n" + 
            		"												<td class=\"fluid-img\" style=\"font-size:0pt; line-height:0pt; text-align:left;\"><img src=\"cid:image\" width=\"650\" height=\"366\" border=\"0\" alt=\"\" /></td>\n" + 
            		"											</tr>\n" + 
            		"											<tr>\n" + 
            		"												<td class=\"p30-15\" style=\"padding: 50px 30px;\">\n" + 
            		"													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" + 
            		"														<tr>\n" + 
            		"															<td class=\"h3 pb20\" style=\"color:#ffffff; font-family:'Muli', Arial,sans-serif; font-size:25px; line-height:32px; text-align:left; padding-bottom:20px;\">Congratulation You Sucessfully booked your Tickets</td>\n" + 
            		"														</tr>\n" + 
            		"														<tr>\n" + 
            		"															<td class=\"text pb20\" style=\"color:#ffffff; font-family:Arial,sans-serif; font-size:14px; line-height:26px; text-align:left; padding-bottom:20px;\">Thanks for choosing Stark Airlines </td>\n" + 
            		"														</tr>\n" + 
            		"														<!-- Button -->\n" + 
            		"														<tr>\n" + 
            		"															<td align=\"left\">\n" + 
            		"																<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" + 
            		"																	<tr>\n" + 
            		"																		\n" + 
            		"																	</tr>\n" + 
            		"																</table>\n" + 
            		"															</td>\n" + 
            		"														</tr>\n" + 
            		"														<!-- END Button -->\n" + 
            		"													</table>\n" + 
            		"												</td>\n" + 
            		"											</tr>\n" + 
            		"										</table>\n" + 
            		"									</td>\n" + 
            		"								</tr>\n" + 
            		"							</table>\n" + 
            		"							<!-- END Article / Full Width Image + Title + Copy + Button -->\n" + 
            		"\n" + 
            		"							\n" + 
            		"							<!-- END Two Columns / Articles -->\n" + 
            		"\n" + 
            		"							<!-- Article / Image On The Left - Copy On The Right -->\n" + 
            		"							\n" + 
            		"							<!-- END Article / Image On The Left - Copy On The Right -->\n" + 
            		"\n" + 
            		"							<!-- CTA Section -->\n" + 
            		"							\n" + 
            		"							\n" + 
            		"							<!-- END Two Columns / Articles -->\n" + 
            		"\n" + 
            		"							<!-- Footer -->\n" + 
            		"							<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" + 
            		"								<tr>\n" + 
            		"									<td class=\"p30-15 bbrr\" style=\"padding: 50px 30px; border-radius:0px 0px 26px 26px;\" bgcolor=\"#0e264b\">\n" + 
            		"										<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" + 
            		"											<tr>\n" + 
            		"												<td align=\"center\" style=\"padding-bottom: 30px;\">\n" + 
            		"													<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" + 
            		"														<tr>\n" + 
            		"															<td class=\"img\" width=\"55\" style=\"font-size:0pt; line-height:0pt; text-align:left;\"><a href=\"#\" target=\"_blank\"><img src=\"cid:icon1\" width=\"38\" height=\"38\" border=\"0\" alt=\"\" /></a></td>\n" + 
            		"															<td class=\"img\" width=\"55\" style=\"font-size:0pt; line-height:0pt; text-align:left;\"><a href=\"#\" target=\"_blank\"><img src=\"cid:icon2\" width=\"38\" height=\"38\" border=\"0\" alt=\"\" /></a></td>\n" + 
            		"															<td class=\"img\" width=\"55\" style=\"font-size:0pt; line-height:0pt; text-align:left;\"><a href=\"#\" target=\"_blank\"><img src=\"cid:icon3\" width=\"38\" height=\"38\" border=\"0\" alt=\"\" /></a></td>\n" + 
            		"															<td class=\"img\" width=\"38\" style=\"font-size:0pt; line-height:0pt; text-align:left;\"><a href=\"#\" target=\"_blank\"><img src=\"cid:icon4\" width=\"38\" height=\"38\" border=\"0\" alt=\"\" /></a></td>\n" + 
            		"														</tr>\n" + 
            		"													</table>\n" + 
            		"												</td>\n" + 
            		"											</tr>\n" + 
            		"											<tr>\n" + 
            		"												<td class=\"text-footer1 pb10\" style=\"color:#c1cddc; font-family:'Muli', Arial,sans-serif; font-size:16px; line-height:20px; text-align:center; padding-bottom:10px;\">Stark Airlines-The Best in Industries</td>\n" + 
            		"											</tr>\n" + 
            		"											<tr>\n" + 
            		"												<td class=\"text-footer2\" style=\"color:#8297b3; font-family:'Muli', Arial,sans-serif; font-size:12px; line-height:26px; text-align:center;\">East Pixel Bld. 99, Creative City 9000, <br />Stark Industries</td>\n" + 
            		"											</tr>\n" + 
            		"										</table>\n" + 
            		"									</td>\n" + 
            		"								</tr>\n" + 
            		"								<tr>\n" + 
            		"									<td class=\"text-footer3 p30-15\" style=\"padding: 40px 30px 0px 30px; color:#475c77; font-family:'Muli', Arial,sans-serif; font-size:12px; line-height:18px; text-align:center;\">\n" + 
            		"										<a href=\"#\" target=\"_blank\" class=\"link2-u\" style=\"color:#475c77; text-decoration:underline;\"><span class=\"link2-u\" style=\"color:#475c77; text-decoration:underline;\">Unsubscribe</span></a> from this mailing list.\n" + 
            		"									</td>\n" + 
            		"								</tr>\n" + 
            		"							</table>\n" + 
            		"							<!-- END Footer -->\n" + 
            		"						</td>\n" + 
            		"					</tr>\n" + 
            		"				</table>\n" + 
            		"			</td>\n" + 
            		"		</tr>\n" + 
            		"	</table>\n" + 
            		"</body>\n" + 
            		"</html>\n" + 
            		"";
            messageBodyPart.setContent(htmlText, "text/html");
            // add it
            multipart.addBodyPart(messageBodyPart);

            // second part (the image)
            messageBodyPart = new MimeBodyPart();
            DataSource fds = new FileDataSource(
               "/home/benaka/Desktop/JAVA MINI PROJECT/AIRLINE/Airline/bin/images/qantas-ad.jpg");
            messageBodyPart.setDataHandler(new DataHandler(fds));
            messageBodyPart.setHeader("Content-ID", "<image>");

            // add image to the multipart
            multipart.addBodyPart(messageBodyPart);

            // put everything together
            message.setContent(multipart);
          
            messageBodyPart = new MimeBodyPart();
            DataSource fds1 = new FileDataSource(
               "/home/benaka/Desktop/JAVA MINI PROJECT/AIRLINE/Airline/bin/images/ico_facebook.jpg");
            messageBodyPart.setDataHandler(new DataHandler(fds1));
            messageBodyPart.setHeader("Content-ID", "<icon1>");

            // add image to the multipart
            multipart.addBodyPart(messageBodyPart);

            // put everything together
            message.setContent(multipart);
            messageBodyPart = new MimeBodyPart();
            DataSource fds2 = new FileDataSource(
               "/home/benaka/Desktop/JAVA MINI PROJECT/AIRLINE/Airline/bin/images/ico_instagram.jpg");
            messageBodyPart.setDataHandler(new DataHandler(fds2));
            messageBodyPart.setHeader("Content-ID", "<icon2>");

            // add image to the multipart
            multipart.addBodyPart(messageBodyPart);

            // put everything together
            message.setContent(multipart);
            messageBodyPart = new MimeBodyPart();
            DataSource fds3 = new FileDataSource(
               "/home/benaka/Desktop/JAVA MINI PROJECT/AIRLINE/Airline/bin/images/ico_linkedin.jpg");
            messageBodyPart.setDataHandler(new DataHandler(fds3));
            messageBodyPart.setHeader("Content-ID", "<icon3>");

            // add image to the multipart
            multipart.addBodyPart(messageBodyPart);

            // put everything together
            message.setContent(multipart);
            messageBodyPart = new MimeBodyPart();
            DataSource fds4 = new FileDataSource(
               "/home/benaka/Desktop/JAVA MINI PROJECT/AIRLINE/Airline/bin/images/ico_twitter.jpg");
            messageBodyPart.setDataHandler(new DataHandler(fds4));
            messageBodyPart.setHeader("Content-ID", "<icon4>");

            // add image to the multipart
            multipart.addBodyPart(messageBodyPart);

            // second part (the image)
            messageBodyPart = new MimeBodyPart();
            DataSource fds5 = new FileDataSource(
               "/home/benaka/Desktop/JAVA MINI PROJECT/AIRLINE/Airline/bin/images/ticket.jpg");
            messageBodyPart.setDataHandler(new DataHandler(fds5));
            messageBodyPart.setHeader("Content-ID", "<icon5>");

            // add image to the multipart
            multipart.addBodyPart(messageBodyPart);
            // put everything together
            message.setContent(multipart);
            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

}
