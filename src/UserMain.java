import java.util.Scanner;

import service.UserService;

public class UserMain {
    public static void main(String[] args) {
        // UserServiceのインスタンスを生成
        UserService userService = new UserService();

        // 入力を受け付けるためのScannerオブジェクト
        try (Scanner scanner = new Scanner(System.in)) {
            // 処理の続行フラグをtrueで初期化
            boolean yesNo = true;
            while (yesNo) {
                // 選択肢を表示
                System.out.println("1: 全件検索, 2: ID検索, 3: 新規登録, 4: 更新, 5: 削除");
                System.out.print("条件を上記番号から選らんで入力してください。: ");
                
                // 操作を選択
                Integer action = scanner.nextInt();

                // 操作に応じて処理を実行
                switch (action) {
                    case 1:
                        // 全件検索
                        userService.findAll();
                        break;
                    case 2:
                        // ID検索
                        System.out.print("検索対象者のIDを入力してください。:");
                        Integer searchId = scanner.nextInt();

                        userService.findById(searchId);
                        break;
                    case 3:
                        // 新規登録
                        System.out.println("登録情報を入力してください。");
                        System.out.print("idを入力してください。: ");
                        Integer saveId = scanner.nextInt();
                        System.out.print("名前を入力してください。: ");
                        String saveName = scanner.next();
                        System.out.print("年齢を入力してください。: ");
                        Integer saveAge = scanner.nextInt();
                        System.out.print("性別を入力してください。: ");
                        Integer saveGender = scanner.nextInt();

                        userService.save(saveId, saveName, saveAge, saveGender);
                        break;
                    case 4:
                        // 更新
                        System.out.println("更新情報を入力してください。");
                        System.out.print("更新対象者のユーザーIDを入力してください。: ");
                        Integer updateId = scanner.nextInt();
                        System.out.print("更新後の年齢を入力してください。: ");
                        Integer updateAge = scanner.nextInt();

                        userService.update(updateId, updateAge);
                        break;
                    case 5:
                        // 削除
                        System.out.println("削除情報を入力してください。");
                        System.out.print("削除対象者のユーザーIDを入力してください。: ");
                        Integer deleteId = scanner.nextInt();

                        userService.delete(deleteId);
                        break;
                }

                // 処理を続行するか選択
                System.out.print("処理を続けますか？(y or n): ");
                // y or Y 以外なら終了
                if (!(scanner.next().equals("y") || scanner.next().equals("Y"))) {
                    // 処理の続行フラグにfalseを設定
                    yesNo = false;
                }

                System.out.println("------------------------------------------------------");
            }
        }

        System.out.println("終了します。");
    }
}