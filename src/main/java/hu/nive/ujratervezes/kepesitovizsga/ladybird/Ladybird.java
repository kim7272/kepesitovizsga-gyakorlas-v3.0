package hu.nive.ujratervezes.kepesitovizsga.ladybird;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Ladybird {

    private DataSource dataSource;

    public Ladybird(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getLadybirdsWithExactNumberOfPoints(int i) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("select hungarian_name from ladybirds where number_of_points = ?");
        ) {
            stmt.setInt(1, i);

            return getNames(stmt);

        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by insert", sqle);
        }
    }

    public List<String> getNames(PreparedStatement stmt) {
        List<String> names = new ArrayList<>();
        try (
                ResultSet rs = stmt.executeQuery();
        ) {
            while (rs.next()) {
                String name = rs.getString("hungarian_name");
                names.add(name);
            }
            return names;
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by insert", sqle);
        }
    }

    public Map<Integer, Integer> getLadybirdsByNumberOfPoints() {

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("select number_of_points from ladybirds");
        ) {

            return createMap(stmt);

        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by insert", sqle);
        }
    }

    public Map<Integer, Integer> createMap(PreparedStatement stmt) {
        Map<Integer, Integer> numberByPoints = new HashMap<>();
        try (
                ResultSet rs = stmt.executeQuery();
        ) {
            while (rs.next()) {
                int number = rs.getInt("number_of_points");
                if (numberByPoints.containsKey(number)) {
                    numberByPoints.put(number, numberByPoints.get(number) + 1);
                } else {
                    numberByPoints.put(number, 1);
                }
            }
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by insert", sqle);
        }
        return numberByPoints;
    }

     public Set<Ladybug> getLadybirdByPartOfLatinNameAndNumberOfPoints(String latinNamePart, int number_of_points) {

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("select * from ladybirds where latin_name like %?% and number_of_points = ?");
        ) {
            stmt.setString(1, latinNamePart);
            stmt.setInt(2, number_of_points);

            return getSet(stmt);

        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by insert", sqle);
        }
    }

    public Set<Ladybug> getSet(PreparedStatement stmt) {
        Set<Ladybug> ladybugs = new HashSet<>();
        try (
                ResultSet rs = stmt.executeQuery();
        ) {
            while (rs.next()) {
               Ladybug ladybug = new Ladybug(rs.getString("hungarian_name"), rs.getString("latin_name"), rs.getString("genus"),
               rs.getInt("number_of_points"));
                ladybugs.add(ladybug);
                System.out.println(ladybug);
            }
            return ladybugs;
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by insert", sqle);
        }
    }


    public Map<String, Integer> getLadybirdStatistics() {
            try (
                    Connection conn = dataSource.getConnection();
                    PreparedStatement stmt =
                            conn.prepareStatement("select genus from ladybirds");
            ) {

                return createStatistics(stmt);

            } catch (SQLException sqle) {
                throw new IllegalArgumentException("Error by insert", sqle);
            }
    }

    public Map<String, Integer> createStatistics(PreparedStatement stmt) {
            Map<String, Integer> numberByGenus = new HashMap<>();
            try (
                    ResultSet rs = stmt.executeQuery();
            ) {
                while (rs.next()) {
                    String type = rs.getString("genus");
                    if (numberByGenus.containsKey(type)) {
                        numberByGenus.put(type, numberByGenus.get(type) + 1);
                    } else {
                        numberByGenus.put(type, 1);
                    }
                }
            } catch (SQLException sqle) {
                throw new IllegalArgumentException("Error by insert", sqle);
            }
            return numberByGenus;
    }
}


