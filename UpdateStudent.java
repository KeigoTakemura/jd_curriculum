import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateStudent {
    public static void main(String[] args) {
        // MySQLデータベースの接続URL
        final String URL = "jdbc:oracle:thin:@localhost:1521/orclpdb";
        // MySQLデータベースのユーザー名
        final String USER_NAME = "keigo";
        // ユーザーのパスワード
        final String USER_PASS = "Jdpass123";

        // 学生ID
        int id = 6;
        // 学生の点数
        int score = 80;

        // studentテーブルのIDに一致する学生の点数を更新するSQL文
        String sql = "UPDATE student SET score = ? WHERE id = ?";
        
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
            ps.setInt(1, score);
            ps.setInt(2, id);
            
            // SELECT文を実行して結果を取得
            int count = ps.executeUpdate();
            // 追加した件数を表示
            System.out.println("【info】" + count + "件更新しました");
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