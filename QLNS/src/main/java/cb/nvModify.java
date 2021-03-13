package cb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * CRUD (insert, update, delete, findAll)
 *
 * @author NamNam
 */
public class nvModify {
    public static List<nv> findAll() {
        List<nv> nvList = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;


        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_manager?" +
                    "useUnicode=yes&characterEncoding=UTF-8", "root", "1234");

            //query
            String sql = "select * from nv";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                nv std = new nv(resultSet.getInt("id"),
                        resultSet.getString("fullname"), resultSet.getString("gioitinh"), resultSet.getString("cv"),
                        resultSet.getString("email"), resultSet.getString("sdt"), resultSet.getString("dc"),
                        resultSet.getInt("tuoi"));
                nvList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(nvModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(nvModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(nvModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.

        return nvList;
    }

    public static void insert(nv std) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_manager?" +
                    "useUnicode=yes&characterEncoding=UTF-8", "root", "1234");
            //query
            String sql = "insert into nv(fullname, gioitinh, cv, tuoi, email, sdt, dc) values(?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);

            statement.setString(1, std.getFullname());
            statement.setString(2, std.getGioitinh());
            statement.setString(3, std.getCv());
            statement.setInt(4, std.getTuoi());
            statement.setString(5, std.getEmail());
            statement.setString(6, std.getSdt());
            statement.setString(7, std.getDc());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(nvModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(nvModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(nvModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }

    public static void update(nv std) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_manager?" +
                    "useUnicode=yes&characterEncoding=UTF-8", "root", "1234");
            //query
            String sql = "update nv set fullname=?, gioitinh=?, cv=?, tuoi=?, email=?, sdt=?, dc=? where id = ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, std.getFullname());
            statement.setString(2, std.getGioitinh());
            statement.setString(3, std.getCv());
            statement.setInt(4, std.getTuoi());
            statement.setString(5, std.getEmail());
            statement.setString(6, std.getSdt());
            statement.setString(7, std.getDc());
            statement.setInt(8, std.getId());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(nvModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(nvModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(nvModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }

    public static void delete(int id) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach nhan vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_manager?" +
                    "useUnicode=yes&characterEncoding=UTF-8", "root", "1234");
            //query
            String sql = "delete from nv where id = ?";
            statement = connection.prepareCall(sql);

            statement.setInt(1, id);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(nvModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(nvModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(nvModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }

    public static List<nv> findByfullname(String fullname) {
        List<nv> nvList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_manager?" +
                    "useUnicode=yes&characterEncoding=UTF-8", "root", "1234");
            //query
            String sql = "select * from nv where fullname like ?";
            statement = connection.prepareStatement(sql);
            statement.setString( 1,"%"+fullname+"%");
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            System.out.println(resultSet);
            while (resultSet.next()) {
                nv std = new nv(resultSet.getInt("id"),
                        resultSet.getString("fullname"), resultSet.getString("gioitinh"), resultSet.getString("cv"),
                        resultSet.getString("email"), resultSet.getString("sdt"), resultSet.getString("dc"),
                        resultSet.getInt("tuoi"));
                nvList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(nvModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(nvModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(nvModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.

        return nvList;
    }
}
