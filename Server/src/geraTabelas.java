import br.edu.ifce.postit.Exception.NoSuchUserException;
import br.edu.ifce.postit.dao.NoteDaoImpl;
import br.edu.ifce.postit.dao.UserDaoImpl;
import br.edu.ifce.postit.model.Note;
import br.edu.ifce.postit.model.User;


public class geraTabelas {

	public static void main(String[] args) {
		
		UserDaoImpl userDao = new UserDaoImpl();
		NoteDaoImpl noteDao = new NoteDaoImpl();
		
		User user = userDao.findByLogin("jp");
		
		Note note = new Note();
		note.setId(1);
		note.setContent("Bosta");
		note.setUser(user);
		
		noteDao.delete(note);
//		for( Note note: noteDao.listNoteByUser(user)){
//				System.out.println("Id: " + note.getId() + " Conteudo: " + note.getContent() + " User_id: " + note.getUser());
//				System.out.println("Id: " + note.getUser().getId() + " Nome: " + note.getUser().getName() + " Login: " + note.getUser().getLogin() + " Password: " + note.getUser().getPassword());
//		}
		
//		try {
//			userDao.delete(user);
//		} catch (NoSuchUserException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println("Id: " + user.getId() + " Nome: " + user.getName() + " Login: " + user.getLogin() + " Password: " + user.getPassword());
		
		
	}
}
