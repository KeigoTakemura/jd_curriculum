package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Dessert;

// DessertDaoの実装クラス
public class DessertDaoImpl implements DessertDao {
    // データベースのURL
    private final String URL = "jdbc:oracle:thin:@localhost:1521/orclpdb";
    //データベースのユーザー名
    private final String USER_NAME = "keigo";
    //ユーザーのパスワード
    private final String USER_PASS = "Jdpass123";
    
    //データベース接続、準備済みステートメント、および結果セットのプライベート変数を宣言する
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    /**
     * dessertテーブルからすべてのレコードを検索します
     * @return Dessertオブジェクトのリスト
     */
    @Override
    public List<Dessert> findAll() {
        // 検索結果を格納するリスト変数
        List<Dessert> desserts = new ArrayList<>();
        // dessertテーブルからすべてのレコードを検索するSQL文
        String sql = "SELECT * FROM dessert";

        try {
            // データベースとの接続
            con = DriverManager.getConnection(URL, USER_NAME, USER_PASS);
            // SELECT文の準備
            ps = con.prepareStatement(sql);
            // SELECT文を実行して結果を取得
            rs = ps.executeQuery();

            // 検索結果を1レコードずつ取り出してリストに追加する
            while(rs.next()) {
                // 1レコード分のDessertオブジェクトのインスタンスを生成
                Dessert dessert = new Dessert();
                dessert.setId(rs.getInt("id"));
                dessert.setName(rs.getString("name"));
                dessert.setPrice(rs.getInt("price"));
                dessert.setTime_id(rs.getInt("time_id"));
                desserts.add(dessert);
            }
        } catch (SQLException e) {
            // 例外が発生した場合にスタックトレースを出力
            e.printStackTrace();
        } finally {
            // リソースを閉じる
            // ResultSetの接続を解除
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
			
            // PreparedStatementの接続を解除
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            // データベース接続の解除
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
		
        // 結果を返す
        return desserts;
    }

    /**
     * dessertテーブルからIDに合致するレコードを検索します
     * @return Dessertオブジェクト
     */
    @Override
    public Dessert findById(int id) {
        // 検索結果を格納する変数
        Dessert dessert = null;
        // dessertテーブルからIDに合致するレコードを検索するSQL文
        String sql = "SELECT * FROM dessert WHERE id = ?";

        try {
            // データベースとの接続
            con = DriverManager.getConnection(URL, USER_NAME, USER_PASS);
            // SELECT文の準備
            ps = con.prepareStatement(sql);
            // SELECT文のパラメーター(プレースホルダー)に値を設定
            ps.setInt(1, id);
            // SELECT文を実行して結果を取得
            rs = ps.executeQuery();

            // 結果セットからレコードを1件ずつ読み込む
            while (rs.next()) {
                // 1レコード分のDessertオブジェクトのインスタンスを生成
                dessert = new Dessert();
                dessert.setId(rs.getInt("id"));
                dessert.setName(rs.getString("name"));
                dessert.setPrice(rs.getInt("price"));
                dessert.setTime_id(rs.getInt("time_id"));
            }
        } catch (SQLException e) {
            // 例外が発生した場合にスタックトレースを出力
            e.printStackTrace();
        } finally {
            // リソースを閉じる
            // ResultSetの接続を解除
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            // PreparedStatementの接続を解除
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            // データベース接続の解除
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        // 結果を返す
        return dessert;
    }

    /**
     * dessertテーブルにデータを追加する
     * @return boolean
     */
    @Override
    public boolean save(Dessert dessert) {
        // 保存が成功したかどうかを示す変数
        boolean result = true;
        // デザートの情報を新規追加するSQL文
        String sql = "INSERT INTO dessert (id, name, price, time_id) VALUES (?, ?, ?, ?)";

        try {
            // データベースとの接続
            con = DriverManager.getConnection(URL, USER_NAME, USER_PASS);
            // SELECT文の準備
            ps = con.prepareStatement(sql);
            // SELECT文のパラメーター(プレースホルダー)に値を設定
            ps.setInt(1, dessert.getId());
            ps.setString(2, dessert.getName());
            ps.setInt(3, dessert.getPrice());
            ps.setInt(4, dessert.getTime_id());
            // SELECT文を実行して、データベースに追加
            ps.executeUpdate();
        } catch (SQLException e) {
            // エラーが発生した場合、resultにfalseを設定
            result = false;
            // 例外が発生した場合にスタックトレースを出力
            e.printStackTrace();
        } finally {
            // リソースを閉じる
            // PreparedStatementの接続を解除
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            // データベース接続の解除
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        // 結果を返す
        return result;
    }

    /**
     * dessertテーブルにデータを更新する
     * @return boolean
     */
    @Override
    public boolean update(Dessert dessert) {
        // 保存が成功したかどうかを示す変数
        boolean result = true;
        // デザートの情報を更新するSQL文
        String sql = "UPDATE dessert SET price = ? WHERE id = ?";

        try {
            // データベースとの接続
            con = DriverManager.getConnection(URL, USER_NAME, USER_PASS);
            // SELECT文の準備
            ps = con.prepareStatement(sql);
            // SELECT文のパラメーター(プレースホルダー)に値を設定
            ps.setInt(1, dessert.getPrice());
            ps.setInt(2, dessert.getId());
            // SELECT文を実行して、データベースを更新
            ps.executeUpdate();
        } catch (SQLException e) {
            // エラーが発生した場合、resultにfalseを設定
            result = false;
            // 例外が発生した場合にスタックトレースを出力
            e.printStackTrace();
        } finally {
            // リソースを閉じる
            // PreparedStatementの接続を解除
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            // データベース接続の解除
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        // 結果を返す
        return result;
    }

    /**
     * dessertテーブルにデータを削除する
     * @return boolean
     */
    @Override
    public boolean delete(int id) {
        // 保存が成功したかどうかを示す変数
        boolean result = true;
        // IDに合致するデザートの情報を削除するSQL文
        String sql = "DELETE FROM dessert WHERE id = ?";
        
        try {
            // データベースとの接続
            con = DriverManager.getConnection(URL, USER_NAME, USER_PASS);
            // SELECT文の準備
            ps = con.prepareStatement(sql);
            // SELECT文のパラメーター(プレースホルダー)に値を設定
            ps.setInt(1, id);
            // SELECT文を実行して、データベースから削除
            ps.executeUpdate();
        } catch (SQLException e) {
            // エラーが発生した場合、resultにfalseを設定
            result = false;
            // 例外が発生した場合にスタックトレースを出力
            e.printStackTrace();
        } finally {
            // リソースを閉じる
            // PreparedStatementの接続を解除
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            // データベース接続の解除
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        // 結果を返す
        return result;
    }
    
    /**
     * dessertテーブルにデータを論理削除する
     * @return boolean
     */
    @Override
    public boolean logical(int id) {
        // 保存が成功したかどうかを示す変数
        boolean result = true;
        // IDに合致するデザートの情報を削除するSQL文
        String sql = "UPDATE dessert SET delete_date = CURRENT_TIMESTAMP WHERE id = ?";
        
        try {
            // データベースとの接続
            con = DriverManager.getConnection(URL, USER_NAME, USER_PASS);
            // SELECT文の準備
            ps = con.prepareStatement(sql);
            // SELECT文のパラメーター(プレースホルダー)に値を設定
            ps.setInt(1, id);
            // SELECT文を実行して、データベースから削除
            ps.executeUpdate();
        } catch (SQLException e) {
            // エラーが発生した場合、resultにfalseを設定
            result = false;
            // 例外が発生した場合にスタックトレースを出力
            e.printStackTrace();
        } finally {
            // リソースを閉じる
            // PreparedStatementの接続を解除
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            // データベース接続の解除
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        // 結果を返す
        return result;
    }
}