package fact.it.projectthemepark.controller;

import fact.it.projectthemepark.model.Staff;
import fact.it.projectthemepark.model.ThemePark;
import fact.it.projectthemepark.model.Visitor;
import fact.it.projectthemepark.model.Attraction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Controller
public class MainController {

    private ArrayList<Staff> staffMembers = new ArrayList<>();
    private ArrayList<Visitor> visitors = new ArrayList<>();
    private ArrayList<ThemePark> themeParks = new ArrayList<>();

    @PostConstruct
    private void fillData(){
        for (Staff staff: fillStaffMembers()) {
            staffMembers.add(staff);
        }
        for (Visitor visitor: fillVisitors()){
            visitors.add(visitor);
        }
        for (ThemePark themePark: fillThemeParks()){
            themeParks.add(themePark);
        }
    }
//Write your code here
    @RequestMapping("/1_newVisitor")
    public String newVisitor(ThemePark themePark, Model model) {

        model.addAttribute("themeParkList", themeParks);

        return "1_newVisitor";
    }

    @RequestMapping("/submitnewvisitor")
    public String submitnewvisitor(HttpServletRequest request, Model model) {

        String firstName = request.getParameter("firstName");
        String surname = request.getParameter("surname");
        Integer yearOfBirth = Integer.parseInt(request.getParameter("yearOfBirth"));
        Integer themeParkIndex = Integer.parseInt(request.getParameter("themeParkIndex"));

        Visitor visitor = new Visitor(firstName, surname);
        visitor.setYearOfBirth(yearOfBirth);
        themeParks.get(themeParkIndex).registerVisitor(visitor);

        visitors.add(visitor);

        model.addAttribute("visitor",visitor);

        return "2_visitorOverview";
    }

    @RequestMapping("/3_newStaff")
    public String newStaff() {
        return "3_newStaff";
    }

    @RequestMapping("/submitnewstaff")
    public String submitnewstaff(HttpServletRequest request, Model model) {

        String firstName = request.getParameter("firstName");
        String surname = request.getParameter("surname");
        LocalDate employedSince = LocalDate.parse(request.getParameter("employedSince"));
        Boolean workingStudent = (request.getParameter("workingStudent") != null);

        Staff staff = new Staff(firstName, surname);
        staff.setStartDate(employedSince);
        staff.setStudent(workingStudent);

        staffMembers.add(staff);

        model.addAttribute("staff",staff);

        return "4_staffOverview";
    }

    @RequestMapping("/5_staffList")
    public String staffList(Staff staff, Model model) {

        model.addAttribute("staffList", staffMembers);

        return "5_staffList";
    }

    @RequestMapping("/6_visitorList")
    public String visitorList(Visitor visitor, Model model) {

        model.addAttribute("visitorList", visitors);

        return "6_visitorList";
    }

    @RequestMapping("/7_newThemePark")
    public String newThemePark() { return "7_newThemePark"; }

    @RequestMapping("/submitnewthemepark")
    public String submitnewthemepark(HttpServletRequest request, Model model) {

        String nameThemePark = request.getParameter("nameThemePark");

        ThemePark themePark = new ThemePark(nameThemePark);

        themeParks.add(themePark);

        model.addAttribute("themeParkList", themeParks);

        return "8_parkList";
    }

    @RequestMapping("/8_parkList")
    public String parkList(ThemePark themePark, Model model) {

        model.addAttribute("themeParkList", themeParks);

        return "8_parkList";
    }

    @RequestMapping("/9_newAttraction")
    public String newAttraction(ThemePark themePark, Staff staff, Model model) {

        model.addAttribute("themeParkList", themeParks);
        model.addAttribute("staffList", staffMembers);

        return "9_newAttraction";
    }

    @RequestMapping("/submitnewattraction")
    public String submitnewattraction(HttpServletRequest request, Model model) {

        String nameAttraction = request.getParameter("nameAttraction");
        Integer durationInSec = Integer.parseInt(request.getParameter("durationInSec"));
        String photo = request.getParameter("photo");
        Integer themeParkIndex = Integer.parseInt(request.getParameter("themePark"));
        Integer staffIndex = Integer.parseInt(request.getParameter("staff"));

        Attraction attraction = new Attraction(nameAttraction, durationInSec);
        attraction.setPhoto(photo);
        attraction.setResponsible(staffMembers.get(staffIndex));

        themeParks.get(themeParkIndex).addAttraction(attraction);

        model.addAttribute("themeParkList", themeParks);
        model.addAttribute("themePark", themeParks.get(themeParkIndex));

        return "10_attractionList";
    }





    private ArrayList<Staff> fillStaffMembers() {
        ArrayList<Staff> staffMembers = new ArrayList<>();

        Staff staff1 = new Staff("Johan", "Bertels");
        staff1.setStartDate(LocalDate.of(2002, 5, 1));
        Staff staff2 = new Staff("An", "Van Herck");
        staff2.setStartDate(LocalDate.of(2019, 3, 15));
        staff2.setStudent(true);
        Staff staff3 = new Staff("Bruno", "Coenen");
        staff3.setStartDate(LocalDate.of(1995,1,1));
        Staff staff4 = new Staff("Wout", "Dayaert");
        staff4.setStartDate(LocalDate.of(2002, 12, 15));
        Staff staff5 = new Staff("Louis", "Petit");
        staff5.setStartDate(LocalDate.of(2020, 8, 1));
        staff5.setStudent(true);
        Staff staff6 = new Staff("Jean", "Pinot");
        staff6.setStartDate(LocalDate.of(1999,4,1));
        Staff staff7 = new Staff("Ahmad", "Bezeri");
        staff7.setStartDate(LocalDate.of(2009, 5, 1));
        Staff staff8 = new Staff("Hans", "Volzky");
        staff8.setStartDate(LocalDate.of(2015, 6, 10));
        staff8.setStudent(true);
        Staff staff9 = new Staff("Joachim", "Henau");
        staff9.setStartDate(LocalDate.of(2007,9,18));
        staffMembers.add(staff1);
        staffMembers.add(staff2);
        staffMembers.add(staff3);
        staffMembers.add(staff4);
        staffMembers.add(staff5);
        staffMembers.add(staff6);
        staffMembers.add(staff7);
        staffMembers.add(staff8);
        staffMembers.add(staff9);
        return staffMembers;
    }

    private ArrayList<Visitor> fillVisitors() {
        ArrayList<Visitor> visitors = new ArrayList<>();
        Visitor visitor1 = new Visitor("Dominik", "Mioens");
        visitor1.setYearOfBirth(2001);
        Visitor visitor2 = new Visitor("Zion", "Noops");
        visitor2.setYearOfBirth(1996);
        Visitor visitor3 = new Visitor("Maria", "Bonetta");
        visitor3.setYearOfBirth(1998);
        Visitor visitor4 = new Visitor("Laurens", "Mattheus");
        visitor4.setYearOfBirth(1999);
        visitors.add(visitor1);
        visitors.add(visitor2);
        visitors.add(visitor3);
        visitors.add(visitor4);
        visitors.get(0).addToWishList("De grote golf");
        visitors.get(0).addToWishList("Sky Scream");
        visitors.get(1).addToWishList("Piratenboot");
        visitors.get(1).addToWishList("Sky Scream");
        visitors.get(1).addToWishList("Halvar the ride");
        visitors.get(1).addToWishList("DreamCatcher");
        visitors.get(2).addToWishList("DinoSplash");
        visitors.get(3).addToWishList("Bounty Tower");
        visitors.get(3).addToWishList("Anubis the Ride");
        return visitors;
    }

    private ArrayList<ThemePark> fillThemeParks() {
        ArrayList<ThemePark> themeparks = new ArrayList<>();
        ThemePark themepark1 = new ThemePark("Plopsaland");
        ThemePark themepark2 = new ThemePark("Plopsa Coo");
        ThemePark themepark3 = new ThemePark("Holiday Park");
        Attraction attraction1 = new Attraction("Anubis the Ride", 60);
        Attraction attraction2 = new Attraction("De grote golf", 180);
        Attraction attraction3 = new Attraction("Piratenboot",150);
        Attraction attraction4 = new Attraction("SuperSplash", 258);
        Attraction attraction5 = new Attraction("Dansende fonteinen");
        Attraction attraction6 = new Attraction("Halvar the ride",130);
        Attraction attraction7 = new Attraction("DinoSplash", 240);
        Attraction attraction8 = new Attraction("Bounty Tower", 180);
        Attraction attraction9 = new Attraction("Sky Scream",50);
        attraction1.setPhoto("/img/anubis the ride.jpg");
        attraction2.setPhoto("/img/de grote golf.jpg");
        attraction3.setPhoto("/img/piratenboot.jpg");
        attraction4.setPhoto("/img/supersplash.jpg");
        attraction5.setPhoto("/img/dansende fonteinen.jpg");
        attraction6.setPhoto("/img/halvar the ride.jpg");
        attraction7.setPhoto("/img/dinosplash.jpg");
        attraction8.setPhoto("/img/bountytower.jpg");
        attraction9.setPhoto("/img/sky scream.jpg");
        attraction1.setResponsible(staffMembers.get(0));
        attraction2.setResponsible(staffMembers.get(1));
        attraction3.setResponsible(staffMembers.get(2));
        attraction4.setResponsible(staffMembers.get(3));
        attraction5.setResponsible(staffMembers.get(4));
        attraction6.setResponsible(staffMembers.get(5));
        attraction7.setResponsible(staffMembers.get(6));
        attraction8.setResponsible(staffMembers.get(7));
        attraction9.setResponsible(staffMembers.get(8));
        themepark1.addAttraction(attraction1);
        themepark1.addAttraction(attraction2);
        themepark1.addAttraction(attraction3);
        themepark1.addAttraction(attraction4);
        themepark2.addAttraction(attraction5);
        themepark2.addAttraction(attraction6);
        themepark3.addAttraction(attraction7);
        themepark3.addAttraction(attraction8);
        themepark3.addAttraction(attraction9);
        themeparks.add(themepark1);
        themeparks.add(themepark2);
        themeparks.add(themepark3);
        return themeparks;
    }
}

