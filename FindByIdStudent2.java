import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindByIdStudent2 {
    public static void main(String[] args) {
        // MySQLデータベースの接続URL
        final String URL = "jdbc:oracle:thin:@localhost:1521/orclpdb";
        // MySQLデータベースのユーザー名
        final String USER_NAME = "keigo";
        // ユーザーのパスワード
        final String USER_PASS = "Jdpass123";

        // 学生ID
        int id = 1;
        //studentテーブルからdelete_dateがnullであるすべてのレコードを検索するSQL文
        String sql = "SELECT * FROM student WHERE delete_date IS NULL AND id = ?";
        
        // データベース接続、準備済みステートメント、および結果セットのプライベート変数を宣言する
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // データベースとの接続
            con = DriverManager.getConnection(URL, USER_NAME, USER_PASS);
            // SELECT文の準備
            ps = con.prepareStatement(sql);
            // パラメーターを設定
            ps.setInt(1, id);
            // SELECT文を実行して結果を取得
            rs = ps.executeQuery();

            // 検索結果をResultSetからレコードを取り出してコンソールに出力
            while (rs.next()) {
                System.out.print("id: " + rs.getInt("id") + ", ");
                System.out.print("name: " + rs.getString("name") + ", ");
                System.out.println("score: " + rs.getInt("score") + "点");
            }
        } catch (SQLException e) {
            // エラーが発生した場合はスタックトレースを出力
            e.printStackTrace();
        } finally {
            // リソースの開放
            // ResultSetのクローズ
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            // PreparedStatmentのクローズ
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            // Connectionのクローズ
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}