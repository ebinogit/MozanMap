package com.example.mozanmap.data

import com.example.mozanmap.R

data class OtherItem(
    val id:Int,
    val title: String,
    val imgID: Int,
    val details: List<OtherItem2>
)
data class OtherItem2(
    val title: String,
    val imgID:Int,
    val details: List<OtherItem3>
)
data class OtherItem3(
    val id:Int,
    val title: String,
    val information: String,
    val linkText: String,
    val url: String,
    val list: List<Int>
)

object OtherData {
    val otherItems = listOf(
        OtherItem3(0,"プール","日本水泳連盟公認、50m×8コースを備えたプール。ダイビング講習なども行われます。","スポーツ・医療カレッジ","https://www.neec.ac.jp/department/sports/", listOf(
                    R.drawable.pool,
                    R.drawable.pool2)),
        OtherItem(1,"体育館",R.drawable.taiikukann, listOf(
            OtherItem2("1F", R.drawable.no, listOf(
                OtherItem3(-1,"メディカルフィットネスセンター(MFC)", "スポーツ医学に基づく最新鋭のマシンを備え、科学的トレーニングを行うほか、スポーツクラブの仕事の流れもまるごと学ぶことができます。","スポーツ・医療カレッジ","https://www.neec.ac.jp/department/sports/",listOf(
                    R.drawable.medical_fitness_center)),
                OtherItem3(-1,"GEM STONE STUDIO", "ダンスパフォーマンス科トータルプロデューサー・SAMが設計・監修した、ダンスパフォーマンス科専用スタジオ「GEM STONE STUDIO」。最新の音響システムを完備しているほか、スタジオの床はダンスレッスンに適したバネ仕込み仕様。多様なジャンルのダンスレッスンに対応できる、最高の学習環境を実現しています。","ダンスパフォーマンス科","https://www.neec.ac.jp/department/music/dance/",listOf(
                    R.drawable.gem_stone_studio,
                    R.drawable.gem_stone_studio_b)),
                OtherItem3(-1,"武道場", "250畳もの広さを誇る武道場は、柔道の授業や柔道部で活用します。","柔道整復科","https://www.neec.ac.jp/department/sports/judoorthopaedics/",listOf(
                    R.drawable.judo_hall)),
                OtherItem3(-1,"メディカルフィットネスセンター(MFC)", "","","",listOf(
                    R.drawable.medical_fitness_center)))),
            OtherItem2("2F", R.drawable.no, listOf(
                OtherItem3(-1,"稽古場", "声優・演劇科の学生が使用する稽古場。","声優・演劇科","https://www.neec.ac.jp/department/creators/actor/",listOf(
                    R.drawable.rehearsal_hall)))))),
        OtherItem(2,"図書館",R.drawable.library2, listOf(
            OtherItem2("1F",R.drawable.tosho_1f, listOf(
                OtherItem3(-1,"入学相談室(広報部)","入学相談、学校見学、入学説明を実施。専任の入学相談スタッフが対応します。","","", listOf(
                    R.drawable.kouhou1,
                    R.drawable.kouhou2,
                    R.drawable.entry_counseling_room)))),
            OtherItem2("2F",R.drawable.tosho_2f, listOf(
                OtherItem3(-1,"キャリアコーオプセンター、就職資料室","就職活動とコーオプ教育だけではなく、インターンシップ、資格試験に関するサポートも行っています。各企業の資料や求人票等はここで閲覧することができます。\n"+"※「キャリアサポートセンター」から名称変更しました。（2020年4月1日）","","", listOf(
                    R.drawable.kyaria,
                    R.drawable.kyaria2)),
                OtherItem3(-1,"学務課教務係","教務関連全般のサポートをしています。主な取扱い事項は次のとおりです。\n"+"・履修手続、授業、成績管理に関すること\n"+"・定期試験に関すること\n"+"・学費に関すること\n"+"・各種証明書の発行（在学、卒業見込、成績等）\n"+"・学割や学生証の発行、再発行\n"+"・住所、氏名等の変更受付\n"+"・休学、復学、退学等に関すること\n"+"・研究生、科目等履修生に関すること\n"+"・その他、教務全般に関すること","","", listOf(
                    R.drawable.no)),
                OtherItem3(-1,"学務課学生係","学生生活全般をサポートしています。主な取扱い事項は次のとおりです。\n"+"・奨学金に関すること\n"+"日本育英会をはじめ、各種奨学金の手続きや相談にお応えします。\n"+"・学生会館に関すること\n"+"学生会館（八王子みなみ野駅前）の入寮管理、手続きを行っています。\n"+"・課外活動に関すること\n"+"課外活動費事務、体育施設利用申込受付（学生）等を行っています。\n"+"・外国人留学生のサポート等\n"+"留学生の学生生活をバックアップしています。\n"+"・学生保険／事故対応\n"+"学生保険手続き、急病や怪我、事故の緊急応対を行っています。\n"+"・アルバイトの斡旋\n"+"Webを中心にアルバイトの紹介を行っています。\n"+"・遺失物／拾得物の管理\n"+"落し物の管理、保管をしています。学外から届いた物も保管しています。\n"+"この他にも幅広く相談にのりますので、気軽に学務課 学生係へ。","","", listOf(
                    R.drawable.gakumu1,
                    R.drawable.gakumu2)))))),
        OtherItem(3,"片柳記念ホール",R.drawable.katayanagi_memorial, listOf(
            OtherItem2("1F",R.drawable.no, listOf(
                OtherItem3(-1,"アンサンブルスタジオ A","ギターやベース、ドラム、キーボードなど、さまざまな楽器を用いたバンドやアンサンブルの練習が行えます。","ミュージックアーティスト科","https://www.neec.ac.jp/department/music/artist/", listOf(
                    R.drawable.ensamble_studio_a)),
                OtherItem3(-1,"アンサンブルスタジオ B","","","", listOf(
                    R.drawable.ensamble_studio_b)),
                OtherItem3(-1,"キーボードルーム","","","", listOf(
                    R.drawable.keyboad)),
                OtherItem3(-1,"セッションルーム","","","", listOf(
                    R.drawable.session)),
                OtherItem3(-1,"トレーニングルーム","","","", listOf(
                    R.drawable.training)))))),
        OtherItem3(4,"テニスコート","全5面のテニスコート。オムニコートのため、天候を気にせずプレイできます。","スポーツ健康学科 テニスコース(3年制・2年制)","https://www.neec.ac.jp/department/sports/health/tennis/",listOf(
                    R.drawable.tennis_court)),
        OtherItem3(5,"弓道場","","","", listOf(
            R.drawable.kyudo,
            R.drawable.kyudo2,
            R.drawable.kyudo3)),
        OtherItem3(6,"総合グラウンド","400m×8コースの陸上トラックと人工芝のフィールド、2,000名収容の観客席を完備しています。","スポーツ・医療カレッジ","https://www.neec.ac.jp/department/sports/", listOf(
            R.drawable.interdisciplinary_playground)),
        OtherItem3(7,"土木・造園実習場","実際の邸宅と庭を忠実に再現した専用実習場。花壇や庭石、樹木などが配置されており、土木技術やガーデニングを実践的に学べる環境が整っています。","","", listOf(
            R.drawable.facility_01)),
        OtherItem3(8,"守衛棟(西門)","国道16号線「東京工科大前」交差点。八王子みなみ野駅行きスクールバス、二輪通学者に利用されています。お車を利用される方は、正門をご利用ください。","","", listOf(
            R.drawable.west_gate)),
        OtherItem3(9,"守衛棟(正門)","国道16号沿い「片倉高校前」交差点を橋本方面に約300m先左折。お車で来校される方は、こちらをご利用ください。","","", listOf(
            R.drawable.main_gate)),
        OtherItem3(10,"多目的グラウンド","サッカーコースのサブ練習場として使用されるほか、幅広いスポーツ学習の舞台となります。","スポーツ・医療カレッジ","https://www.neec.ac.jp/department/sports/", listOf(
            R.drawable.multipurpose_playground)),
        OtherItem3(11,"クラブハウス","","","", listOf(
            R.drawable.no)),
        OtherItem3(12,"スマートハウス実習棟","エネルギー、エコ・スマート技術の専門家を育成するため、株式会社ヤマダホームズとの産学連携により、ソーラーパネル（三菱電機製）や各種スマート家電、蓄電池など最新のスマート技術を結集した実習施設。","電子・電気科","https://www.neec.ac.jp/department/technology/electronic/", listOf(
            R.drawable.smart_house2)),
        OtherItem(13,"本部棟",R.drawable.honbutou, listOf(
            OtherItem2("1F",R.drawable.honbu1f, listOf(
                OtherItem3(-1,"デジタルツインセンター","仮想空間上に現実と同じ環境を再現する“デジタルツイン”技術。この“デジタルツイン”に関する研究を推進するセンターを2023年6月1日に開設しました。","","", listOf(
                    R.drawable.dejitarutuin1,
                    R.drawable.dejitarutuin2)),
                OtherItem3(-1,"業務課","■ 業務課庶務係\n"+"学内外の全般的な事務の他、各種申請等の提出、受付等を行っています。学位記授与式や入学式の開催、学会のサポート等も行っています。\n"+"■ 業務課教育教材係\n"+"教育研究施設・設備等に関する事務を行っています。主な取扱い事項は次のとおりです。\n"+"・教室のAV器機に関すること\n"+"・教育研究に使用する器機等に関すること\n"+"・片柳研究所、実験棟A、講義･実験棟等で行われる各学部の実験、演習の補助","","", listOf(
                    R.drawable.kyoumu1,
                    R.drawable.kyoumu2)))),
            OtherItem2("2F",R.drawable.no, listOf(
                OtherItem3(-1,"入試・アドミッションオフィスセンター","■ 入試・アドミッションオフィスセンター\n"+"入学試験方法等の入試制度全般について調査を行い、本学の入学試験の企画と実施に関する業務を行っています。","","", listOf(
                    R.drawable.no)
                ))
            ))
        )
    )
}
