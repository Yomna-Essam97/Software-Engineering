// package com.project.controller;
//
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.util.ArrayList;
// import java.util.List;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.servlet.ModelAndView;
//
// import com.project.entities.Questions;
// import com.project.repository.QuestionRepository;
//
// @Controller
// public class PlayController {
// private static String GAME;
// private static String COURSE;
//
// @Autowired
// private QuestionRepository repos;
//
// @GetMapping("/show")
// public String showQuestions(Model model, @RequestParam("game") String game,
// @RequestParam("course") String course) {
// PlayController.GAME = game;
// PlayController.COURSE = course;
// Iterable<Questions> questionsIT = repos.findAll();
// List<Questions> questionsList = new ArrayList<Questions>();
// for (Questions question : questionsIT) {
// if (question.getGname().equals(game) && question.getGcourse().equals(course))
// {
// questionsList.add(question);
// }
// }
// model.addAttribute("questions", questionsList);
// return "Play";
// }
//
// @RequestMapping("/answers")
// public ModelAndView Play(String game, String course, @RequestParam("answer1")
// String answer1,
// @RequestParam("answer2") String answer2, @RequestParam("answer3") String
// answer3) throws SQLException {
// game = GAME;
// course = COURSE;
// // ArrayList<String> answers = new ArrayList<String>();
// ModelAndView mv = new ModelAndView();
// int score = 0;
//
// Iterable<Questions> questionsIT = repos.findAll();
// List<Questions> questionsList = new ArrayList<Questions>();
// for (Questions question : questionsIT) {
// if (question.getGname().equals(game) && question.getGcourse().equals(course))
// {
// questionsList.add(question);
// }
// }
//
// if (answer1.equals(questionsList.get(0).getAnswer())) {
// score++;
// }
// if (answer2.equals(questionsList.get(1).getAnswer())) {
// score++;
// }
// if (answer3.equals(questionsList.get(2).getAnswer())) {
// score++;
// }
// updateScore(score);
//
// mv.setViewName("Play");
// mv.addObject("answers", score);
// return mv;
//
// }
//
// private void updateScore(int s) throws SQLException {
// Connection conn =
// DriverManager.getConnection("jdbc:mysql://localhost:3306/brightminds?useSSL=false",
// "nouran",
// "root");
// Statement stmt = conn.createStatement();
// ResultSet rs = stmt.executeQuery("SELECT * FROM users");
// while (rs.next()) {
// String name = rs.getString("name");
// String password = rs.getString("password");
// Integer id = rs.getInt("id");
// if (name.equals(LoginController.loggedname) &&
// password.equals(LoginController.loggedpassword)) {
// stmt = conn.createStatement();
// String sql = "UPDATE users " + "SET score = " + s + " Where id = " + id;
// stmt.executeUpdate(sql);
// }
// }
// }
//
// }
