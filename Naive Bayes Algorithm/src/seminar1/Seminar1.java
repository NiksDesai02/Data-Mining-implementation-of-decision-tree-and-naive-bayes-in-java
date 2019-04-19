package seminar1;

/**
 *
 * @author niks desai
 */
import java.util.Scanner;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Seminar1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        // TODO code application logic here
        String s1,s2,s3,s4;
        
        System.out.println("Enter values of all 4 predictor variables : ");
        System.out.print("Outlook : ");
        s1 = sc.next();
        System.out.print("Temp : ");
        s2 = sc.next();
        System.out.print("Humidity : ");
        s3 = sc.next();
        System.out.print("Windy : ");
        s4 = sc.next();
        
        double y=0,n=0,fp1=0,fp2=0,p1y = 0,p2y = 0,p3y = 0,p4y = 0,p1n = 0,p2n = 0,p3n = 0,p4n = 0,pory=0,prn=0,pooy=0,poon=0,posy=0,posn=0,pthy=0,pthn=0,ptmy=0,ptmn=0,ptcy=0,ptcn=0,phhy=0,phhn=0,phny=0,phnn=0,pwfy=0,pwfn=0,pwty=0,pwtn=0;
        
        Connection myconn = null;
        Statement myStmt = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/seminar","root","");
            myStmt  = myconn.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT `Outlook`, `Temp`, `Humidity`, `Windy`, `PlayGolf` FROM `naivebayes` WHERE Outlook = 'Rainy' AND PlayGolf = 'Yes'";
        ResultSet rs = null;
        try {
            rs = myStmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs.next()){
                pory++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql = "SELECT `Outlook`, `Temp`, `Humidity`, `Windy`, `PlayGolf` FROM `naivebayes` WHERE Outlook = 'Rainy' AND PlayGolf = 'No'";
        rs = null;
        try {
            rs = myStmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs.next()){
                prn++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql = "SELECT `Outlook`, `Temp`, `Humidity`, `Windy`, `PlayGolf` FROM `naivebayes` WHERE Outlook = 'Overcast' AND PlayGolf = 'No'";
        rs = null;
        try {
            rs = myStmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs.next()){
                poon++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql = "SELECT `Outlook`, `Temp`, `Humidity`, `Windy`, `PlayGolf` FROM `naivebayes` WHERE Outlook = 'Overcast' AND PlayGolf = 'Yes'";
        rs = null;
        try {
            rs = myStmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs.next()){
                pooy++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql = "SELECT `Outlook`, `Temp`, `Humidity`, `Windy`, `PlayGolf` FROM `naivebayes` WHERE Outlook = 'Sunny' AND PlayGolf = 'No'";
        rs = null;
        try {
            rs = myStmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs.next()){
                posn++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql = "SELECT `Outlook`, `Temp`, `Humidity`, `Windy`, `PlayGolf` FROM `naivebayes` WHERE Outlook = 'Sunny' AND PlayGolf = 'Yes'";
        rs = null;
        try {
            rs = myStmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs.next()){
                posy++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql = "SELECT `Outlook`, `Temp`, `Humidity`, `Windy`, `PlayGolf` FROM `naivebayes` WHERE Temp = 'Hot' AND PlayGolf = 'No'";
        rs = null;
        try {
            rs = myStmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs.next()){
                pthn++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql = "SELECT `Outlook`, `Temp`, `Humidity`, `Windy`, `PlayGolf` FROM `naivebayes` WHERE Temp = 'Hot' AND PlayGolf = 'Yes'";
        rs = null;
        try {
            rs = myStmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs.next()){
                pthy++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql = "SELECT `Outlook`, `Temp`, `Humidity`, `Windy`, `PlayGolf` FROM `naivebayes` WHERE Temp = 'Mild' AND PlayGolf = 'No'";
        rs = null;
        try {
            rs = myStmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs.next()){
                ptmn++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql = "SELECT `Outlook`, `Temp`, `Humidity`, `Windy`, `PlayGolf` FROM `naivebayes` WHERE Temp = 'Mild' AND PlayGolf = 'Yes'";
        rs = null;
        try {
            rs = myStmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs.next()){
                ptmy++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql = "SELECT `Outlook`, `Temp`, `Humidity`, `Windy`, `PlayGolf` FROM `naivebayes` WHERE Temp = 'Cool' AND PlayGolf = 'No'";
        rs = null;
        try {
            rs = myStmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs.next()){
                ptcn++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql = "SELECT `Outlook`, `Temp`, `Humidity`, `Windy`, `PlayGolf` FROM `naivebayes` WHERE Temp = 'Cool' AND PlayGolf = 'Yes'";
        rs = null;
        try {
            rs = myStmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs.next()){
                ptcy++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql = "SELECT `Outlook`, `Temp`, `Humidity`, `Windy`, `PlayGolf` FROM `naivebayes` WHERE Humidity = 'High' AND PlayGolf = 'No'";
        rs = null;
        try {
            rs = myStmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs.next()){
                phhn++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql = "SELECT `Outlook`, `Temp`, `Humidity`, `Windy`, `PlayGolf` FROM `naivebayes` WHERE Humidity = 'High' AND PlayGolf = 'Yes'";
        rs = null;
        try {
            rs = myStmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs.next()){
                phhy++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql = "SELECT `Outlook`, `Temp`, `Humidity`, `Windy`, `PlayGolf` FROM `naivebayes` WHERE Humidity = 'Normal' AND PlayGolf = 'No'";
        rs = null;
        try {
            rs = myStmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs.next()){
                phnn++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql = "SELECT `Outlook`, `Temp`, `Humidity`, `Windy`, `PlayGolf` FROM `naivebayes` WHERE Humidity = 'Normal' AND PlayGolf = 'Yes'";
        rs = null;
        try {
            rs = myStmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs.next()){
                phny++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql = "SELECT `Outlook`, `Temp`, `Humidity`, `Windy`, `PlayGolf` FROM `naivebayes` WHERE Windy = 'True' AND PlayGolf = 'No'";
        rs = null;
        try {
            rs = myStmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs.next()){
                pwtn++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql = "SELECT `Outlook`, `Temp`, `Humidity`, `Windy`, `PlayGolf` FROM `naivebayes` WHERE Windy = 'True' AND PlayGolf = 'Yes'";
        rs = null;
        try {
            rs = myStmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs.next()){
                pwty++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql = "SELECT `Outlook`, `Temp`, `Humidity`, `Windy`, `PlayGolf` FROM `naivebayes` WHERE Windy = 'False' AND PlayGolf = 'No'";
        rs = null;
        try {
            rs = myStmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs.next()){
                pwfn++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql = "SELECT `Outlook`, `Temp`, `Humidity`, `Windy`, `PlayGolf` FROM `naivebayes` WHERE Windy = 'False' AND PlayGolf = 'Yes'";
        rs = null;
        try {
            rs = myStmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs.next()){
                pwfy++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql = "SELECT `Outlook`, `Temp`, `Humidity`, `Windy`, `PlayGolf` FROM `naivebayes` WHERE PlayGolf = 'Yes'";
        rs = null;
        try {
            rs = myStmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs.next()){
                y++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql = "SELECT `Outlook`, `Temp`, `Humidity`, `Windy`, `PlayGolf` FROM `naivebayes` WHERE PlayGolf = 'No'";
        rs = null;
        try {
            rs = myStmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs.next()){
                n++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Seminar1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        switch(s1){
            case("Rainy")    : p1y = pory/y;
                               p1n = prn/n;
                               break;
            case("Sunny")    : p1y = posy/y;
                               p1n = posn/n;
                               break;
            case("Overcast") : p1y = pooy/y;
                               p1n = poon/n;
                               break;
        }
        switch(s2){
            case("Hot")     : p2y = pthy/y;
                              p2n = pthn/n;
                              break;
            case("Mild")    : p2y = ptmy/y;
                              p2n = ptmn/n;
                              break;
            case("Cool")    : p2y = ptcy/y;
                              p2n = ptcn/n;
                              break;
        }
        switch(s3){
            case("High")    : p3y = phhy/y;
                              p3n = phhn/n;
                              break;
            case("Normal")  : p3y = phny/y;
                              p3n = phnn/n;
                              break;
        }
        switch(s4){
            case("False")    : p4y = pwfy/y;
                               p4n = pwfn/n;
                               break;
            case("True")    :  p4y = pwty/y;
                               p4n = pwtn/n;
                               break;
        }
        fp1 = p1y * p2y * p3y * p4y * (y/(y+n));
        fp2 = p1n * p2n * p3n * p4n * (n/(y+n));
        
        /*System.out.println("p1y =" + pory + "  " + y);
        System.out.println("p1n =" + prn + " " +n);
        System.out.println("p1y1 =" + posy + " " + y);
        System.out.println("p1n1 =" + posn + " " + n);
        System.out.println("p1y2 =" + pooy + " " +y);
        System.out.println("p1n2 =" + poon + " " +n);
        System.out.println("p3y =" + phhy + " " + y);
        System.out.println("p3n =" + phhn +" " +n);
        System.out.println("p3y1 =" + phny + " " +y);
        System.out.println("p3y1 =" + phnn + " " +n);
        System.out.println("p4y =" + pwfy+ " " +y);
        System.out.println("p4y =" + pwfn+ " " +n);
        System.out.println("p4y1 =" + pwty+ " " +y);
        System.out.println("p4y1 =" + pwtn+ " " +n);
        System.out.println();
        System.out.println("p2y =" + pthy + "  " + y);
        System.out.println("p2n =" + pthn + " " +n);
        System.out.println("p2y1 =" + ptmy + " " + y);
        System.out.println("p2n1 =" + ptmn + " " + n);
        System.out.println("p2y2 =" + ptcy + " " +y);
        System.out.println("p2n2 =" + ptcn + " " +n);*/
        
        
        System.out.println("Probability of Yes = " + fp1);
        System.out.println("Probability of No  = " + fp2);
        
        if(fp1 > fp2)
            System.out.println("According to Naive Bayes algorithm, Play Golf is : YES");
        else
            
            System.out.println("According to Naive Bayes algorithm, Play Golf is : NO");
    }
}
