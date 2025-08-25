# Janken (Java)

Java学習用に作成したじゃんけんゲームです。  

- 入力: `Scanner` を使用（0: ぐー / 1: ちょき / 2: ぱー）
- 乱数: `Random` でCPUの手を決定
- 構造: `enum` による手の表現、勝敗判定メソッド `judge`
- バリデーション: 数字以外や 0/1/2 以外の入力を再入力要求
- ループ: `y` で再戦可能

## 実行方法
```bash
javac Janken.java
java Janken
