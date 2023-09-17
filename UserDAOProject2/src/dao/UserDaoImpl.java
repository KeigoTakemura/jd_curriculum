package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.User;

// UserDaoの実装クラス
public class UserDaoImpl implements UserDao {
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
     * usersテーブルからすべてのレコードを検索します
     * @return Userオブジェクトのリスト
     */
    @Override
    public List<User> findAll() {
        // 検索結果を格納するリスト変数
        List<User> users = new ArrayList<>();
        // studentテーブルからすべてのレコードを検索するSQL文
        String sql = "SELECT * FROM users";

        try {
            // データベースとの接続
            con = DriverManager.getConnection(URL, USER_NAME, USER_PASS);
            // SELECT文の準備
            ps = con.prepareStatement(sql);
            // SELECT文を実行して結果を取得
            rs = ps.executeQuery();

            // 検索結果を1レコードずつ取り出してリストに追加する
            while(rs.next()) {
                // 1レコード分のUserオブジェクトのインスタンスを生成
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                user.setGender(rs.getInt("gender"));
                users.add(user);
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
        return users;
    }

    /**
     * usersテーブルからIDに合致するレコードを検索します
     * @return Userオブジェクト
     */
    @Override
    public User findById(int id) {
        // 検索結果を格納する変数
        User user = null;
        // usersテーブルからIDに合致するレコードを検索するSQL文
        String sql = "SELECT * FROM users WHERE id = ?";

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
                // 1レコード分のStudentオブジェクトのインスタンスを生成
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                user.setGender(rs.getInt("gender"));
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
        return user;
    }

    /**
     * userテーブルにデータを追加する
     * @return boolean
     */
    @Override
    public boolean save(User user) {
        // 保存が成功したかどうかを示す変数
        boolean result = true;
        // ユーザー情報を新規追加するSQL文
        String sql = "INSERT INTO users (id, name, age, gender) VALUES (?, ?, ?, ?)";

        try {
            // データベースとの接続
            con = DriverManager.getConnection(URL, USER_NAME, USER_PASS);
            // SELECT文の準備
            ps = con.prepareStatement(sql);
            // SELECT文のパラメーター(プレースホルダー)に値を設定
            ps.setInt(1, user.getId());
            ps.setString(2, user.getName());
            ps.setInt(3, user.getAge());
            ps.setInt(4, user.getGender());
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
     * usersテーブルにデータを更新する
     * @return boolean
     */
    @Override
    public boolean update(User user) {
        // 保存が成功したかどうかを示す変数
        boolean result = true;
        // ユーザー情報を更新するSQL文
        String sql = "UPDATE users SET age = ? WHERE id = ?";

        try {
            // データベースとの接続
            con = DriverManager.getConnection(URL, USER_NAME, USER_PASS);
            // SELECT文の準備
            ps = con.prepareStatement(sql);
            // SELECT文のパラメーター(プレースホルダー)に値を設定
            ps.setInt(1, user.getAge());
            ps.setInt(2, user.getId());
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
     * usersテーブルにデータを削除する
     * @return boolean
     */
    @Override
    public boolean delete(int id) {
        // 保存が成功したかどうかを示す変数
        boolean result = true;
        // IDに合致するユーザー情報を削除するSQL文
        String sql = "DELETE FROM users WHERE id = ?";
        
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
         * usersテーブルにデータを論理削除する
         * @return boolean
         */
        @Override
        public boolean logical(int id) {
            // 保存が成功したかどうかを示す変数
            boolean result = true;
            // IDに合致する学生情報を削除するSQL文
            String sql = "UPDATE users SET delete_date = CURRENT_TIMESTAMP WHERE id = ?";
            
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