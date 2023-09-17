package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Fruit;

// UserDaoの実装クラス
public class FruitDaoImpl implements FruitDao {
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
     * fruitテーブルからすべてのレコードを検索します
     * @return Fruitオブジェクトのリスト
     */
    @Override
    public List<Fruit> findAll() {
        // 検索結果を格納するリスト変数
        List<Fruit> fruits = new ArrayList<>();
        // fruitテーブルからすべてのレコードを検索するSQL文
        String sql = "SELECT * FROM fruit";

        try {
            // データベースとの接続
            con = DriverManager.getConnection(URL, USER_NAME, USER_PASS);
            // SELECT文の準備
            ps = con.prepareStatement(sql);
            // SELECT文を実行して結果を取得
            rs = ps.executeQuery();

            // 検索結果を1レコードずつ取り出してリストに追加する
            while(rs.next()) {
                // 1レコード分のFruitオブジェクトのインスタンスを生成
                Fruit fruit = new Fruit();
                fruit.setId(rs.getInt("id"));
                fruit.setName(rs.getString("name"));
                fruit.setPrice(rs.getInt("price"));
                fruit.setPrefecture_id(rs.getInt("prefecture_id"));
                fruit.setSeason_id(rs.getInt("season_id"));
                fruits.add(fruit);
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
        return fruits;
    }

    /**
     * fruitテーブルからIDに合致するレコードを検索します
     * @return Fruitオブジェクト
     */
    @Override
    public Fruit findById(int id) {
        // 検索結果を格納する変数
        Fruit fruit = null;
        // fruitテーブルからIDに合致するレコードを検索するSQL文
        String sql = "SELECT * FROM fruit WHERE id = ?";

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
                // 1レコード分のFruitオブジェクトのインスタンスを生成
                fruit = new Fruit();
                fruit.setId(rs.getInt("id"));
                fruit.setName(rs.getString("name"));
                fruit.setPrice(rs.getInt("price"));
                fruit.setPrefecture_id(rs.getInt("prefecture_id"));
                fruit.setSeason_id(rs.getInt("season_id"));
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
        return fruit;
    }

    /**
     * fruitテーブルにデータを追加する
     * @return boolean
     */
    @Override
    public boolean save(Fruit fruit) {
        // 保存が成功したかどうかを示す変数
        boolean result = true;
        // ユーザー情報を新規追加するSQL文
        String sql = "INSERT INTO fruit (id, name, price, prefecture_id, season_id) VALUES (?, ?, ?, ?, ?)";

        try {
            // データベースとの接続
            con = DriverManager.getConnection(URL, USER_NAME, USER_PASS);
            // SELECT文の準備
            ps = con.prepareStatement(sql);
            // SELECT文のパラメーター(プレースホルダー)に値を設定
            ps.setInt(1, fruit.getId());
            ps.setString(2, fruit.getName());
            ps.setInt(3, fruit.getPrice());
            ps.setInt(4, fruit.getPrefecture_id());
            ps.setInt(5, fruit.getSeason_id());
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
     * fruitテーブルにデータを更新する
     * @return boolean
     */
    @Override
    public boolean update(Fruit fruit) {
        // 保存が成功したかどうかを示す変数
        boolean result = true;
        // フルーツの情報を更新するSQL文
        String sql = "UPDATE fruit SET price = ? WHERE id = ?";

        try {
            // データベースとの接続
            con = DriverManager.getConnection(URL, USER_NAME, USER_PASS);
            // SELECT文の準備
            ps = con.prepareStatement(sql);
            // SELECT文のパラメーター(プレースホルダー)に値を設定
            ps.setInt(1, fruit.getPrice());
            ps.setInt(2, fruit.getId());
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
     * fruitテーブルにデータを削除する
     * @return boolean
     */
    @Override
    public boolean delete(int id) {
        // 保存が成功したかどうかを示す変数
        boolean result = true;
        // IDに合致するユーザー情報を削除するSQL文
        String sql = "DELETE FROM fruit WHERE id = ?";
        
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
     * fruitテーブルにデータを論理削除する
     * @return boolean
     */
    @Override
    public boolean logical(int id) {
        // 保存が成功したかどうかを示す変数
        boolean result = true;
        // IDに合致するフルーツの情報を削除するSQL文
        String sql = "UPDATE fruit SET delete_date = CURRENT_TIMESTAMP WHERE id = ?";
        
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