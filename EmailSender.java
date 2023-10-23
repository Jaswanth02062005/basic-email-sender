import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class EmailSender {
    private Map<String, String> emailContacts;
    private Map<String, String> emailSettings;

    public EmailSender() {
        emailContacts = new HashMap<>();
        emailSettings = new HashMap<>();
    }

    public void composeAndSendEmail(String to, String subject, String message) {
        if (emailContacts.containsKey(to)) {
            String recipientEmail = emailContacts.get(to);
            String senderEmail = emailSettings.get("email");
            System.out.println("Email sent from " + senderEmail + " to " + recipientEmail);
            System.out.println("Subject: " + subject);
            System.out.println("Message: " + message);
        } else {
            System.out.println("Recipient not found in contacts.");
        }
    }

    public void addContact(String name, String email) {
        emailContacts.put(name, email);
        System.out.println("Contact added: " + name + " (" + email + ")");
    }

    public void setSetting(String key, String value) {
        emailSettings.put(key, value);
        System.out.println("Setting updated: " + key + " = " + value);
    }

    public static void main(String[] args) {
        EmailSender emailSender = new EmailSender();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Compose and send email");
            System.out.println("2. Add a contact");
            System.out.println("3. Update email settings");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Recipient's name: ");
                    String recipientName = scanner.nextLine();
                    System.out.print("Subject: ");
                    String subject = scanner.nextLine();
                    System.out.print("Message: ");
                    String message = scanner.nextLine();
                    emailSender.composeAndSendEmail(recipientName, subject, message);
                    break;
                case 2:
                    System.out.print("Contact name: ");
                    String contactName = scanner.nextLine();
                    System.out.print("Email: ");
                    String contactEmail = scanner.nextLine();
                    emailSender.addContact(contactName, contactEmail);
                    break;
                case 3:
                    System.out.print("Setting key: ");
                    String settingKey = scanner.nextLine();
                    System.out.print("Setting value: ");
                    String settingValue = scanner.nextLine();
                    emailSender.setSetting(settingKey, settingValue);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
