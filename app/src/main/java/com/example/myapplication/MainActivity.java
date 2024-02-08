package com.example.myapplication;

import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private String[] randomStrings = {
            "猫は自分のスケジュールを厳守します。人間の都合は関係ありません。",
            "猫の目は、あなたの行動を冷静に監視しています。",
            "猫のしっぽは、彼らがあなたに興味を持っているかどうかを示します。たぶん。",
            "猫は優雅に歩くことができます。でも、時々ドタバタもします。",
            "猫は自分の時間を大切にします。あなたの時間はどうでもいいです。",
            "猫は高い場所が好きです。あなたの頭の上も含まれます。",
            "猫は個性的な存在です。あなたが理解できるかどうかは別問題です。",
            "猫は狩りの天才です。でも、あなたの足元で遊ぶこともあります。",
            "猫は人間の心を癒す力を持っています。でも、それは彼らの意図ではありません。",
            " 猫は寝るのが上手です。あなたが起きている時に限って、活動的になります。",
            " 猫は独立心が強いです。あなたの依存心には興味ありません。",
            " 猫は柔軟な身体を持っています。あなたの家具も柔軟性を試されます。",
            " 猫は好奇心旺盛です。特に、あなたが大切なものを隠している時に限って。",
            " 猫は鳴き声が可愛いです。でも、朝の4時に鳴かれると可愛さも半減します。",
            " 猫は独自のコミュニケーション方法を持っています。あなたがそれを理解することはありません。",
            " 猫は独特の寝相を見せます。あなたのベッドを占拠することもあります。",
            " 猫は狩りのために鋭い爪を持っています。あなたの家具も狩りの対象です。",
            " 猫は独特の匂いを放ちます。あなたの服にもそれが移ることでしょう。",
            " 猫は独自の遊び方をします。あなたの足を攻撃することもあります。",
            " 猫は人間の感情を察知することがあります。でも、それを利用してあなたを操ることもあります。",
            " 猫は毛づくろいが大好きです。あなたの髪の毛も彼らのターゲットです。",
            " 猫は独特の食事習慣を持っています。あなたの食べ物に興味津々です。",
            " 猫は独自の狩りのテクニックを持っています。あなたの足元で狩りごっこをすることもあります。",
            " 猫は独特の睡眠サイクルを持っています。あなたが寝ている時に限って、活発になります。",
            " 猫は独自の運動量を持っています。あなたの家の中を疾走することもあります。",
            " 猫は独特の好みを持っています。あなたのお気に入りのものに興味津々です。",
            " 猫は独自の習慣を持っています。あなたのルーティンを邪魔することもあります。",
            " 猫は独特の体温を持っています。あなたの膝の上で暖を取ることもあります。",
            " 猫は独特の警戒心を持っています。あなたの友達に対しても疑いの目を向けることもあります。",
            " 猫は独特の愛され方をします。あなたが愛情を求める時に限って、無関心になります。"
    };

    private int[] randomImages = {
            R.drawable.kant_1,
            R.drawable.kant_2,
            R.drawable.kant_3,
            R.drawable.kant_4,
            R.drawable.kant_5,
            R.drawable.kant_6,
            R.drawable.kant_7,
            R.drawable.kant_8,
            R.drawable.kant_9,
            R.drawable.kant_10,
            R.drawable.kant_11,
            R.drawable.kant_12,
            R.drawable.kant_13,
            R.drawable.kant_14,
            R.drawable.kant_15,
            R.drawable.kant_16,
            R.drawable.kant_17,
            R.drawable.kant_18,
            R.drawable.kant_19,
            R.drawable.kant_20,
            R.drawable.kant_21,
            R.drawable.kant_22,
            R.drawable.kant_23,

            // 他の画像も同様に追加
    };

    private MediaPlayer[] mediaPlayers; // 複数のMediaPlayerオブジェクト

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 背景を設定
        getWindow().setBackgroundDrawableResource(R.drawable.background_image);

        Button myButton = findViewById(R.id.myButton);
        final TextView myTextView = findViewById(R.id.myTextView);
        final TextView dateTextView = findViewById(R.id.dateTextView);
        final ImageView myImageView = findViewById(R.id.myImageView);

        // MediaPlayerオブジェクトを初期化
        mediaPlayers = new MediaPlayer[]{
                MediaPlayer.create(this, R.raw.sound1),
                MediaPlayer.create(this, R.raw.sound2),
                MediaPlayer.create(this, R.raw.sound3),
                MediaPlayer.create(this, R.raw.sound4),
                // 他のサウンドも同様に追加
        };

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ボタンクリック時にランダムなサウンドを再生
                playRandomSound();

                // ランダムなテキストを表示
                String randomString = getRandomString();
                myTextView.setText(randomString);

                // 現在の日付を表示
                String currentDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
                dateTextView.setText(currentDate);

                // ランダムな画像を表示
                int randomImage = getRandomImage();
                myImageView.setImageResource(randomImage);
            }
        });
    }

    private String getRandomString() {
        Random random = new Random();
        int index = random.nextInt(randomStrings.length);
        return randomStrings[index];
    }

    private int getRandomImage() {
        Random random = new Random();
        int index = random.nextInt(randomImages.length);
        return randomImages[index];
    }

    // ランダムなサウンドを再生するメソッド
    private void playRandomSound() {
        Random random = new Random();
        int index = random.nextInt(mediaPlayers.length);
        MediaPlayer mediaPlayer = mediaPlayers[index];

        mediaPlayer.seekTo(0); // サウンドを最初から再生
        mediaPlayer.start();   // サウンド再生開始
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        for (MediaPlayer mediaPlayer : mediaPlayers) {
            if (mediaPlayer != null) {
                mediaPlayer.release(); // アクティビティが破棄されるときにMediaPlayerを解放
            }
        }
    }
}