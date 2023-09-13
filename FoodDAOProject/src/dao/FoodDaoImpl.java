package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Food;

// FoodDaoの実装クラス
public class FoodDaoImpl implements FoodDao {
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
     * drinkテーブルからすべてのレコードを検索します
     * @return Foodオブジェクトのリスト
     */
    @Override
    public List<Food> findAll() {
        // 検索結果を格納するリスト変数
        List<Food> foods = new ArrayList<>();
        // foodテーブルからすべてのレコードを検索するSQL文
        String sql = "SELECT * FROM food";

        try {
            // データベースとの接続
            con = DriverManager.getConnection(URL, USER_NAME, USER_PASS);
            // SELECT文の準備
            ps = con.prepareStatement(sql);
            // SELECT文を実行して結果を取得
            rs = ps.executeQuery();

            // 検索結果を1レコードずつ取り出してリストに追加する
            while(rs.next()) {
                // 1レコード分のFoodオブジェクトのインスタンスを生成
                Food food = new Food();
                food.setId(rs.getInt("id"));
                food.setName(rs.getString("name"));
                food.setPrice(rs.getInt("price"));
                food.setTime_id(rs.getInt("time_id"));
                foods.add(food);
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
        return foods;
    }

    /**
     * foodテーブルからIDに合致するレコードを検索します
     * @return Foodオブジェクト
     */
    @Override
    public Food findById(int id) {
        // 検索結果を格納する変数
        Food food = null;
        // foodテーブルからIDに合致するレコードを検索するSQL文
        String sql = "SELECT * FROM food WHERE id = ?";

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
                // 1レコード分のFoodオブジェクトのインスタンスを生成
                food = new Food();
                food.setId(rs.getInt("id"));
                food.setName(rs.getString("name"));
                food.setPrice(rs.getInt("price"));
                food.setTime_id(rs.getInt("time_id"));
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
        return food;
    }

    /**
     * foodテーブルにデータを追加する
     * @return boolean
     */
    @Override
    public boolean save(Food food) {
        // 保存が成功したかどうかを示す変数
        boolean result = true;
        // ドリンクの情報を新規追加するSQL文
        String sql = "INSERT INTO food (id, name, price, time_id) VALUES (?, ?, ?, ?)";

        try {
            // データベースとの接続
            con = DriverManager.getConnection(URL, USER_NAME, USER_PASS);
            // SELECT文の準備
            ps = con.prepareStatement(sql);
            // SELECT文のパラメーター(プレースホルダー)に値を設定
            ps.setInt(1, food.getId());
            ps.setString(2, food.getName());
            ps.setInt(3, food.getPrice());
            ps.setInt(4, food.getTime_id());
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
     * foodテーブルにデータを更新する
     * @return boolean
     */
    @Override
    public boolean update(Food food) {
        // 保存が成功したかどうかを示す変数
        boolean result = true;
        // フードの情報を更新するSQL文
        String sql = "UPDATE food SET price = ? WHERE id = ?";

        try {
            // データベースとの接続
            con = DriverManager.getConnection(URL, USER_NAME, USER_PASS);
            // SELECT文の準備
            ps = con.prepareStatement(sql);
            // SELECT文のパラメーター(プレースホルダー)に値を設定
            ps.setInt(1, food.getPrice());
            ps.setInt(2, food.getId());
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
     * foodテーブルにデータを削除する
     * @return boolean
     */
    @Override
    public boolean delete(int id) {
        // 保存が成功したかどうかを示す変数
        boolean result = true;
        // IDに合致するフードの情報を削除するSQL文
        String sql = "DELETE FROM food WHERE id = ?";
        
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