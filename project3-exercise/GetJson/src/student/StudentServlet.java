package student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * StudentServlet implementation class Servlet
 */
@WebServlet("/StudentServlet")
@MultipartConfig
public class StudentServlet extends HttpServlet {
	List<Student> student = new ArrayList<Student>();
	
	public StudentServlet() {
		student.add(new Student("aaa",20));
		student.add(new Student("bbb",50));
	}

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Student> student = new ArrayList<Student>();
		
		
		student.add(new Student("aaa",20));
		student.add(new Student("bbb",50));
		
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(new ListStudent(student, "Hello From Server"));
		
		PrintWriter writer = response.getWriter();
		writer.print(jsonString);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String search = request.getParameter("search");
		  Gson gson = new Gson();
		  
		  List<Student> res = student.stream().filter(s -> s.getName().equals(search)).collect(Collectors.toList());
		  
		  String jsonString = gson.toJson(new ListStudent(res, "Hello From Server"));
		  PrintWriter writer = response.getWriter();
		  writer.print(jsonString);
	}

}
