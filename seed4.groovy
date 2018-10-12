import hudson.model.User
import hudson.tasks.Mailer

def users = User.getAll()
for (User u : users) {
    def mailAddress = u.getProperty(Mailer.UserProperty.class).getAddress()
    print(mailAddress + "; ")
}
