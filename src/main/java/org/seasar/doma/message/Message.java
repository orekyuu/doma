/*
 * Copyright 2004-2010 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.doma.message;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import org.seasar.doma.internal.message.MessageResourceBundle;

/**
 * デフォルトロケール用のメッセージの列挙です。
 * 
 * @author taedium
 * 
 */
public enum Message implements MessageResource {

    // doma
    DOMA0001("パラメータ[{0}]がnullです。"),
    DOMA0002("パラメータ[{0}]が不正です。理由は次のとおりです。{1}"),
    DOMA0003("Domaのjarファイルのバージョンが実行時と注釈処理時で異なっています（実行時={0}, 注釈処理時={1}）。Eclipseを使用している場合、ビルドパス（Build Path）とファクトリパス（Factory Path）を確認し、プロジェクトのクリーンを実行してください。javacを利用している場合、classpathとprocessorpathのオプションを確認してください。Webアプリケーションの場合、WEB-INF/libに古いjarファイルが存在しないことを確認してください。"),

    // wrapper
    DOMA1006("ドメインの値をラップするのに失敗しました。原因は次のものです。{0}"),
    DOMA1007("型[{0}]の値[{1}]に対応するラッパークラスが見つかりません。"),

    // jdbc
    DOMA2001("SQLの実行結果が1件ではありませんでした。\nSQLファイルパス=[{0}]。\nログ用SQL=[{1}]。"),
    DOMA2002("カラム[{0}]が結果セットに含まれますが、このカラムにマッピングされたプロパティがエンティティクラス[{2}]に見つかりません。次の3つの内のいずれかの対応が必要です。1)エンティティクラスに[{1}]という名前のプロパティを定義する。2)任意の名前のプロパティに@Columnを注釈し@Columnのname要素に[{0}]を指定する。3)UnknownColumnHandlerに未知のカラムを無視するような実装をしorg.seasar.doma.jdbc.Configに設定する。\nSQLファイルパス=[{3}]。\nログ用SQL=[{4}]"),
    DOMA2003("楽観的排他制御により更新処理が失敗しました。\nSQLファイルパス=[{0}]。\nログ用SQL=[{1}]。"),
    DOMA2004("一意制約違反により更新処理が失敗しました。\nSQLファイルパス=[{0}]。\nログ用SQL=[{1}]。\n詳しい原因は次のものです。{2}"),
    DOMA2005("SQLの実行結果が0件でした。\nSQLファイルパス=[{0}]。\nログ用SQL=[{1}]。"),
    DOMA2006("SQLの実行結果が1列ではありませんでした。\nSQLファイルパス=[{0}]。\nログ用SQL=[{1}]。"),
    DOMA2008("JDBCに関する操作に失敗しました。原因は次のものです。{1}"),
    DOMA2009("SQLの実行に失敗しました。\nSQLファイルパス=[{0}]。\nログ用SQL=[{1}]。\n原因は次のものです。{2}。\n根本原因は次のものです。{3}"),
    DOMA2010("SQLファイル[{0}]のデータを取得できませんでした。原因は次のものです。{1}"),
    DOMA2011("SQLファイル[{0}]がクラスパスから見つかりませんでした。"),
    DOMA2012("スクリプトファイル[{0}]がクラスパスから見つかりませんでした。"),
    DOMA2015("java.sql.Connectionの取得に失敗しました。原因は次のものです。{0}"),
    DOMA2016("java.sql.PreparedStatementの取得に失敗しました。\nSQLファイルパス=[{0}]。\n実際のSQL=[{1}]。\n原因は次のものです。{2}"),
    DOMA2017("エンティティ[{0}]のIDプロパティの生成に失敗しました。"),
    DOMA2018("エンティティ[{0}]のIDプロパティの生成に失敗しました。原因は次のものです。{1}"),
    DOMA2019("Wrapperクラス[{0}]がJDBCの型にマッピングされていません。"),
    DOMA2020("エンティティ[{0}]のIDプロパティ[{1}]に値が設定されていません。IDのプロパティに@GeneratedValueが指定されていない場合、INSERTの実行にはIDプロパティの設定が必須です。"),
    DOMA2021("エンティティ[{0}]のIDプロパティ[{1}]に自動生成のstrategy[{2}]が指定されていますが、DBMS[{3}]ではサポートされていません。"),
    DOMA2022("IDプロパティのないエンティティ[{0}]の更新や削除はできません。"),
    DOMA2023("悲観的排他制御は、DBMS[{0}]ではサポートされていません。"),
    DOMA2024("テーブル名もしくはカラム名を指定した悲観的排他制御は、DBMS[{0}]ではサポートされていません。"),
    DOMA2025("java.sql.CallableStatementの取得に失敗しました。\n実際のSQL=[{0}]。\n原因は次のものです。{1}"),
    DOMA2028("楽観的排他制御によりバッチ更新処理が失敗しました。\nSQLファイルパス=[{0}]。\n実際のSQL=[{1}]。"),
    DOMA2029("一意制約違反によりバッチ更新処理が失敗しました。\nSQLファイルパス=[{0}]。\n実際のSQL=[{1}]。\n詳しい原因は次のものです。{2}"),
    DOMA2030("バッチ更新処理の実行に失敗しました。\nSQLファイルパス=[{0}]。\n実際のSQL=[{1}]。\n原因は次のものです。{2}。\n根本原因は次のものです。{3}"),
    DOMA2032("java.sql.Statementの取得に失敗しました。原因は次のものです。{0}"),
    DOMA2033("インスタンス変数[{0}]が未設定です。"),
    DOMA2034("クラス[{0}]のサポートされてないメソッド[{1}]が呼び出されました。"),
    DOMA2035("org.seasar.doma.jdbc.Configの実装クラス[{0}]のメソッド[{1}]からnullが返されました。"),
    DOMA2040("列挙型[{0}]に定数名[{1}]は存在しません。"),
    DOMA2041("自動コミットモードの無効化に失敗しました。原因は次のものです。{0}"),
    DOMA2042("自動コミットモードの有効化に失敗しました。原因は次のものです。{0}"),
    DOMA2043("コミットに失敗しました。原因は次のものです。{0}"),
    DOMA2044("ロールバックに失敗しました。原因は次のものです。{0}"),
    DOMA2045("トランザクションを開始しようとしましたが失敗しました。トランザクション[{0}]がすでに開始されています。"),
    DOMA2046("トランザクションをコミットしようとしましたが失敗しました。トランザクションが開始されていません。"),
    DOMA2048("コネクションを取得しようとしましたが失敗しました。トランザクションが開始されていません。"),
    DOMA2049("コネクションの遅延取得に失敗しました。原因は次のものです。{0}"),
    DOMA2051("セーブポイント[{0}]の作成に失敗しました。原因は次のものです。{1}"),
    DOMA2052("セーブポイント[{0}]のロールバックに失敗しました。原因は次のものです。{1}"),
    DOMA2053("セーブポイント[{0}]を作成しようとしましたが失敗しました。トランザクションが開始されていません。"),
    DOMA2054("セーブポイント[{0}]が見つかりませんでした。セーブポイントをロールバックする前に[{0}]という名前のセーブポイントを作成していることを確認してください。"),
    DOMA2055("トランザクション分離レベル[{0}]の設定に失敗しました。原因は次のものです。{1}"),
    DOMA2056("トランザクション分離レベルの取得に失敗しました。原因は次のものです。{0}"),
    DOMA2057("セーブポイント[{0}]の作成有無を確認しようとしましたが失敗しました。トランザクションが開始されていません。"),
    DOMA2059("セーブポイント[{0}]がすでに存在します。同じ名前のセーブポイントを複数作成することはできません。"),
    DOMA2060("セーブポイント[{0}]の削除に失敗しました。原因は次のものです。{1}"),
    DOMA2061("セーブポイント[{0}]を削除しようとしましたが失敗しました。トランザクションが開始されていません。"),
    DOMA2062("セーブポイント[{0}]をロールバックしようとしましたが失敗しました。トランザクションが開始されていません。"),
    DOMA2063("ローカルトランザクション[{0}]を開始しました。"),
    DOMA2064("ローカルトランザクション[{0}]を終了しました。"),
    DOMA2065("ローカルトランザクション[{0}]のセーブポイント[{1}]を作成しました。"),
    DOMA2067("ローカルトランザクション[{0}]をコミットしました。"),
    DOMA2068("ローカルトランザクション[{0}]をロールバックしました。"),
    DOMA2069("ローカルトランザクション[{0}]のセーブポイント[{1}]へロールバックしました。"),
    DOMA2070("ローカルトランザクション[{0}]のロールバックに失敗しました。"),
    DOMA2071("自動コミットモードの有効化に失敗しました。"),
    DOMA2072("トランザクション分離レベル[{0}]の設定に失敗しました。"),
    DOMA2073("java.sql.Connectionのクローズに失敗しました。"),
    DOMA2074("java.sql.Statementのクローズに失敗しました。"),
    DOMA2075("java.sql.ResultSetのクローズに失敗しました。"),
    DOMA2076("SQLログ : SQLファイル=[{0}],\n{1}"),
    DOMA2077("スクリプトの実行に失敗しました。\nSQLファイル=[{1}]。\n行番号=[{2}]。\n原因は次のものです。{3}。\nSQL=[{0}]。"),
    DOMA2078("SQLファイル[{0}]の読み込みに失敗しました。\n原因は次のものです。{1}"),
    DOMA2079("WAITオプション付きの悲観的排他制御は、DBMS[{0}]ではサポートされていません。"),
    DOMA2080("NOWAITオプション付きの悲観的排他制御は、DBMS[{0}]ではサポートされていません。"),
    DOMA2081("テーブル名もしくはカラム名を指定したWAITオプション付きの悲観的排他制御は、DBMS[{0}]ではサポートされていません。"),
    DOMA2082("テーブル名もしくはカラム名を指定したNOWAITオプション付きの悲観的排他制御は、DBMS[{0}]ではサポートされていません。"),
    DOMA2101("SQLの解析に失敗しました。（[{1}]行目[{2}]番目の文字付近）。文字列リテラルの終了を示すクォテーション['']が見つかりません。SQL[{0}]"),
    DOMA2102("SQLの解析に失敗しました。（[{1}]行目[{2}]番目の文字付近）。ブロックコメントの終了を示す文字列[*/]が見つかりません。SQL[{0}]"),
    DOMA2104("SQLの解析に失敗しました。（[{1}]行目[{2}]番目の文字付近）。/*%end*/に対応する/*%if ...*/または/*%for ...*/が見つかりません。SQL[{0}]"),
    DOMA2109("SQLの解析に失敗しました。（[{1}]行目[{2}]番目の文字付近）。閉じ括弧に対応する開き括弧が見つかりません。SQL[{0}]"),
    DOMA2110("SQLの解析に失敗しました。（[{1}]行目[{2}]番目の文字付近）。バインド変数コメント[{3}]の直後にテスト用のリテラルもしくは括弧が見つかりません。SQL[{0}]"),
    DOMA2111("SQLの組み立てに失敗しました。（[{1}]行目[{2}]番目の文字付近）。原因は次のものです。{3}。SQL[{0}]"),
    DOMA2112("SQLの組み立てに失敗しました。（[{1}]行目[{2}]番目の文字付近）。括弧の前に位置するバインド変数コメント[{3}]に対応するオブジェクトの型[{4}]がjava.lang.Iterableのサブタイプではありません。SQL[{0}]"),
    DOMA2115("SQLの組み立てに失敗しました。（[{1}]行目[{2}]番目の文字付近）。括弧の前に位置するバインド変数コメント[{3}]に対応するjava.lang.Iterableの[{4}]番目の要素がnullです。SQL[{0}]"),
    DOMA2116("SQLの組み立てに失敗しました。（[{1}]行目[{2}]番目の文字付近）。埋め込み変数コメント[{3}]にシングルクォテーションが含まれています。SQL[{0}]"),
    DOMA2117("SQLの組み立てに失敗しました。（[{1}]行目[{2}]番目の文字付近）。埋め込み変数コメント[{3}]にセミコロンが含まれています。SQL[{0}]"),
    DOMA2118("SQLの組み立てに失敗しました。（[{1}]行目[{2}]番目の文字付近）。バインド変数コメント[{3}]を正しく扱えませんでした。原因は次のものです。{4}。SQL[{0}]"),
    DOMA2119("SQLの組み立てに失敗しました（[{1}]行目[{2}]番目の文字付近）。ブロックコメントを/*%で開始する場合、続く文字列は、if、else、elseif、for、end、expand のいずれかでなければいけません。SQL[{0}]"),
    DOMA2120("SQLの解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。バインド変数コメント[{3}]が定義されていますが、バインド変数が空文字です。SQL[{0}]"),
    DOMA2121("SQLの解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。埋め込み変数コメント[{3}]が定義されていますが、埋め込み変数が空文字です。SQL[{0}]"),
    DOMA2122("SQLの組み立てに失敗しました（[{1}]行目[{2}]番目の文字付近）。埋め込み変数コメント[{3}]に行コメントが含まれています。SQL[{0}]"),
    DOMA2123("SQLの組み立てに失敗しました（[{1}]行目[{2}]番目の文字付近）。埋め込み変数コメント[{3}]にブロックコメントが含まれています。SQL[{0}]"),
    DOMA2124("SQLの解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。--/*%for ...*/の中にトークン[:]が見つかりません。SQL[{0}]"),
    DOMA2125("SQLの解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。--/*%for ...*/の中のトークン[:]の前に識別子が見つかりません。SQL[{0}]"),
    DOMA2126("SQLの解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。--/*%for ...*/の中のトークン[:]の後に式が見つかりません。SQL[{0}]"),
    DOMA2129("SQLの組み立てに失敗しました（[{1}]行目[{2}]番目の文字付近）。/*%for ...*/の中のトークン[:]の後に続く式[{3}]に対応するオブジェクトの型[{4}]がjava.lang.Iterableのサブタイプではありません。SQL[{0}]"),
    DOMA2133("SQLの解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。/%if ...*/が/*%end*/で閉じられていません。/%if ...*/と/*%end*/の組は、同じ節（たとえばSELECT、FROM、WHERE節など）の中に存在しなければいけません。SQL[{0}]"),
    DOMA2134("SQLの解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。/%for ...*/が/*%end*/で閉じられていません/%for ...*/と/*%end*/の組は、同じ節（たとえばSELECT、FROM、WHERE節など）の中に存在しなければいけません。SQL[{0}]"),
    DOMA2135("SQLの解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。括弧が閉じられていません。もしくは/%if ...*/～/*%end*/や/%for ...*/～/*%end*/を使用していて、開き括弧と閉じ括弧が同じブロック内にありません。SQL[{0}]"),
    DOMA2136("Daoメソッドのパラメータ[{0}]に対応する結果セットがストアドプロシージャもしくはストアドファンクション[{1}]から返されませんでした。"),
    DOMA2137("[{0}]番目のパラメータ[{1}]に対応する結果セットがストアドプロシージャもしくはストアドファンクション[{2}]から返されませんでした。"),
    DOMA2138("SQLの解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。/*%elseif ...*/に対応する/*%if ...*/が見つかりません。SQL[{0}]"),
    DOMA2139("SQLの解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。/*%else*/の後ろに/*%elseif ...*/が存在します。SQL[{0}]"),
    DOMA2140("SQLの解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。/*%else*/に対応する/*%if ...*/が見つかりません。SQL[{0}]"),
    DOMA2141("SQLの解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。複数の/*%else*/が存在します。SQL[{0}]"),
    DOMA2142("SQLの解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。バインド変数コメント[{3}]の直後の値[{4}]はテスト用のリテラルとして不正です。バインド変数コメントの直後は、文字列、数値、日時を表すリテラル、もしくは開き括弧でなければいけません。SQL[{0}]"),
    DOMA2143("SQLの解析に失敗しました。（[{1}]行目[{2}]番目の文字付近）。カラム展開コメント[{3}]の直後にアスタリスク(*)が見つかりません。SQL[{0}]"),
    DOMA2144("SQLの組み立てに失敗しました。（[{1}]行目[{2}]番目の文字付近）。カラム展開コメント[{3}]でカラムを展開できません。結果セットの1レコードがマッピングされる型を確認してください。1レコードにマッピングされる型はエンティティクラスでなければいけません。SQL[{0}]"),
    DOMA2201("ページング用SQLに変換するには元のSQLにorder by句が指定されている必要があります。"),
    DOMA2202("ドメインクラス[{0}]に対応するメタクラス[{1}]が見つかりませんでした。原因は次のものです。{2}"),
    DOMA2203("エンティティクラス[{0}]に対応するメタクラス[{1}]が見つかりませんでした。原因は次のものです。{2}"),
    DOMA2204("クラス[{0}]の型は基本型もしくはドメイン型でなければいけません。詳細な原因は次のものです。{1}"),
    DOMA2205("クラス[{0}]は、@Domainが注釈されていなければいけません。"),
    DOMA2206("クラス[{0}]は、@Entityが注釈されていなければいけません。"),
    DOMA2207("エンティティプロパティ[{1}]がエンティティクラス[{0}]に定義されていません。"),
    DOMA2208("エンティティクラス[{0}]のエンティティプロパティ[{1}]へのアクセスに失敗しました。原因は次のものです。{2}"),
    DOMA2211("エンティティプロパティ[{1}]がエンティティクラス[{0}]で見つかりません。原因は次のものです。{2}"),
    DOMA2212("エンティティクラス[{0}]の@OriginalStatesが注釈されたフィールド[{1}]へのアクセスに失敗しました。原因は次のものです。{2}"),
    DOMA2213("@OriginalStatesが注釈されたフィールド[{1}]がエンティティクラス[{0}]で見つかりません。原因は次のものです。{2}"),
    DOMA2214("ドメインクラス[{0}]に対応するメタクラス[{1}]が見つかりませんでした。原因は次のものです。{2}"),
    DOMA2215("クラス[{0}]のメソッド[{1}]が見つかりませんでした。原因は次のものです。{2}"),
    DOMA2216("エンティティクラス[{0}]のプロパティ{1}に結果セットのカラムの値がマッピングされませんでした。完全なマッピングには結果セットがカラム{2}を含んでいる必要があります。SQLが正しいことを確認してください。このエラーを無視するには、@Selectや@Functionや@ResultSetのensureResultMapping要素にfalseを設定してください。\nSQLファイルパス=[{3}]。\nログ用SQL=[{4}]"),
    DOMA2217("パラメータはクラス[{0}]のサブタイプでなければいけません。"),
    DOMA2218("パラメータ[{0}]はインタフェース[{1}]のインスタンスでなければいけません。"),
    DOMA2219("クラス[{0}]に@Entityが注釈されていません"),

    // expression
    DOMA3001("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。クラス[{2}]のメソッド[{3}]の実行に失敗しました。原因は次のものです。{4}"),
    DOMA3002("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。クラス[{2}]のメソッド[{3}]が見つかりませんでした。メソッド名、パラメータの数、パラメータの型が正しいか確認してください。"),
    DOMA3003("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。変数[{2}]に対応するオブジェクトを解決できませんでした。変数名が正しいか確認してください。"),
    DOMA3004("式[{0}]の解析に失敗しました（[{1}]番目の文字付近）。文字列リテラルの終了を示すダブルクォテーション[\"]が見つかりません。"),
    DOMA3005("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。クラス[{2}]が見つかりませんでした。クラス名が正しいか確認してください。"),
    DOMA3006("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。コンストラクタ[{2}]が見つかりませんでした。コンストラクタのパラメータの数や型が正しいか確認してください。"),
    DOMA3007("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。コンストラクタ[{2}]の実行に失敗しました。原因は次のものです。{3}"),
    DOMA3008("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。比較演算子[{2}]の実行に失敗しました。被演算子のクラスがjava.lang.Comparableを実装していないか、2つの被演算子の型が比較不可能なのかもしれません。原因は次のものです。{3}"),
    DOMA3009("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。比較演算子[{2}]の実行に失敗しました。どちらかの値がnullの場合には、比較できません。"),
    DOMA3010("式[{0}]の解析に失敗しました（[{1}]番目の文字付近）。演算子[{2}]に対する被演算子が見つかりませんでした。"),
    DOMA3011("式[{0}]の解析に失敗しました（[{1}]番目の文字付近）。サポートされていないトークン[{2}]が見つかりました。"),
    DOMA3012("式[{0}]の解析に失敗しました（[{1}]番目の文字付近）。不正な数値リテラル[{2}]が見つかりました。"),
    DOMA3013("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。算術演算子[{2}]の実行に失敗しました。被演算子[{3}]のクラス[{4}]が数値型ではありません。"),
    DOMA3014("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。算術演算子[{2}]の実行に失敗しました。原因は次のものです。{3}"),
    DOMA3015("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。演算子[{2}]の実行に失敗しました。被演算子の値がnullです。"),
    DOMA3016("式[{0}]の解析に失敗しました（[{1}]番目の文字付近）。文字リテラルの終了を示すクォテーション['']が見つかりません。文字リテラルの長さは1でなければいけません。"),
    DOMA3018("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。クラス[{2}]のフィールド[{3}]が見つかりませんでした。フィールド名が正しいか確認してください。"),
    DOMA3019("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。クラス[{2}]のフィールド[{3}]へのアクセスに失敗しました。原因は次のものです。{4}"),
    DOMA3020("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。演算子[{2}]の実行に失敗しました。文字の連結を行う場合、右被演算子[{3}]のクラス[{4}]はString、Character、charのいずれかでなければいけません。数値を加算する場合、両被演算子は数値型でなければいけません。"),
    DOMA3021("式[{0}]の解析に失敗しました（[{1}]番目の文字付近）。トークン[.]の直後にはフィールド名もしくはメソッド名が続かなければいけません。"),
    DOMA3022("式[{0}]の解析に失敗しました（[{1}]番目の文字付近）。トークン[.]の直後にはフィールド名もしくはメソッド名が続かなければいけませんが、文字[{2}]がJavaの識別子の最初の文字として不正です。"),
    DOMA3023("式[{0}]の解析に失敗しました（[{1}]番目の文字付近）。トークン[@]の直後にはクラスの完全修飾名もしくは組み込み関数名が続かなければいけません。"),
    DOMA3024("式[{0}]の解析に失敗しました（[{1}]番目の文字付近）。トークン[@]の直後には組み込み関数名が続かなければいけませんが、文字[{2}]がJavaの識別子の最初の文字として不正です。"),
    DOMA3025("式[{0}]の解析に失敗しました（[{1}]番目の文字付近）。組み込み関数名の直後にトークン[(]が必要です。"),
    DOMA3026("式[{0}]の解析に失敗しました（[{1}]番目の文字付近）。括弧が閉じられていません。"),
    DOMA3027("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。式[{2}]がnullと評価されためメソッド[{3}]を実行できませんでした。"),
    DOMA3028("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。関数[{2}]が見つかりませんでした。関数名、パラメータの数、パラメータの型が正しいか確認してください。"),
    DOMA3029("式[{0}]の解析に失敗しました（[{1}]番目の文字付近）。トークン[@]の直後にはstaticなフィールド名もしくはメソッド名が続かなければいけません。"),
    DOMA3030("式[{0}]の解析に失敗しました（[{1}]番目の文字付近）。トークン[@]の直後にはstaticなフィールド名もしくはメソッド名が続かなければいけませんが、文字[{2}]がJavaの識別子の最初の文字として不正です。"),
    DOMA3031("式[{0}]の解析に失敗しました（[{1}]番目の文字付近）。クラス名の終了を示すトークン[@]の前に、クラス名として不正な文字[{2}]がみつかりました。"),
    DOMA3032("式[{0}]の解析に失敗しました（[{1}]番目の文字付近）。クラス名はトークン[@]で囲まなければいけません。"),
    DOMA3033("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。クラス[{2}]のstaticフィールド[{3}]が見つかりませんでした。フィールド名が正しいか確認してください。"),

    // apt
    DOMA4001("戻り値の型は更新件数を示すintでなければいけません。"),
    DOMA4002("パラメータの数は1つでなければいけません。"),
    DOMA4003("パラメータはエンティティクラスでなければいけません。"),
    DOMA4005("@Selectや@Updateなど問い合わせの種別を表すアノテーションが必要です。"),
    DOMA4007("戻り値のjava.util.Listに対する実型引数の型[{0}]はサポートされていません。"),
    DOMA4008("戻り値の型[{0}]はサポートされていません。戻り値の型は次のいずれかでなければいけません。"),
    DOMA4011("クラス[{0}]のアノテーション処理に失敗しました。原因は次のものです。{1}"),
    DOMA4014("インタフェース以外には注釈できません。"),
    DOMA4015("クラス以外には注釈できません。"),
    DOMA4016("予期しない例外が発生しました。原因の詳細についてはログ(EclipseならばError Logビュー、javacならばコンソールなど)を確認してください。"),
    DOMA4017("Daoインタフェースはトップレベルでなければいけません。"),
    DOMA4018("エンティティクラスはトップレベルでなければいけません。"),
    DOMA4019("ファイル[{0}]がクラスパスから見つかりませんでした。ファイルの絶対パスは\"{1}\"です。"),
    DOMA4020("SQLファイル[{0}]が空です。"),
    DOMA4021("パス[{0}]はディレクトリです。ファイルでなければいけません。絶対パスは\"{1}\"です。"),
    DOMA4024("@Versionが重複しています。@Versionが注釈されるフィールドはクラス階層の中で1つでなければいけません。"),
    DOMA4025("[{0}]で始まる名前はDomaにより予約されているため使用できません。"),
    DOMA4026("[{0}]で終わる名前は自動生成されるクラスの名前と重複する可能性があります。"),
    DOMA4030("@SequenceGeneratorを使用する場合、同じフィールドに@GeneratedValue(strategy = GenerationType.SEQUENCE)を指定しなければいけません。"),
    DOMA4031("@TableGeneratorを使用する場合、同じフィールドに@GeneratedValue(strategy = GenerationType.TABLE)を指定しなければいけません。"),
    DOMA4033("@GeneratedValueを使用する場合、同じフィールドに@Idを指定しなければいけません。"),
    DOMA4034("@GeneratedValueのstrategy要素にGenerationType.SEQUECNEを指定する場合、@SequenceGeneratorの指定も必要です。"),
    DOMA4035("@GeneratedValueのstrategy要素にGenerationType.TABLEを指定する場合、@TableGeneratorの指定も必要です。"),
    DOMA4036("@GeneratedValueを使用する場合、エンティティクラスの階層で@Idは１つのみでなければいけません。"),
    DOMA4037("複数の@GeneratedValueが見つかりました。@GeneratedValueは1つでなければいけません。"),
    DOMA4038("EntityListener[{0}]の実型引数の型[{1}]はエンティティクラス[{2}]のスーパータイプでなければいけません。"),
    DOMA4039("コンパイルが失敗している可能性があるためaptの処理を中止します。コンパイルが失敗している原因については実行環境（Eclipseやjavac）のエラーメッセージを確認してください。このメッセージが生成された箇所を知りたい場合は、ログ(EclipseならばError Logビュー、javacならばコンソールなど)を確認してください。"),
    DOMA4040("戻り値の型は更新件数を示すintの配列でなければいけません。"),
    DOMA4042("型はjava.lang.Iterableのサブタイプでなければいけません。"),
    DOMA4043("java.lang.Iterableのサブタイプに対する実型引数はエンティティクラスでなければいけません。"),
    DOMA4051("エンティティクラスには型パラメータを定義できません。"),
    DOMA4053("SelectOption型のパラメータは複数指定できません。"),
    DOMA4059("Daoインタフェースには型パラメータを定義できません。"),
    DOMA4062("@ResultSetが注釈されたパラメータの型は、java.util.Listでなければいけません。"),
    DOMA4063("@Functionの戻り値として型[{0}]はサポートされていません。"),
    DOMA4064("@Procedureが注釈されたメソッドの戻り値の型はvoidでなければいけません。"),
    DOMA4065("戻り値のjava.util.Listに対する実型引数の型[{0}]は、サポートされていません。"),
    DOMA4066("@Functionもしくは@Procedureが注釈されたメソッドのパラメータには、@In、@InOut、@Out、@ResultSetのいずれかの注釈が必須です。"),
    DOMA4067("SQL内の変数[{0}]に対応するパラメータがメソッドに存在しません（[{1}]番目の文字付近）。"),
    DOMA4068("SQLファイル[{0}]の読み込みに失敗しました。原因は次のものです。{1}"),
    DOMA4069("SQLファイル[{0}]の解析に失敗しました。原因は次のものです。{1}"),
    DOMA4071("式[{0}]（[{1}]番目の文字付近）に含まれる変数[{2}]（フィールドもしくはメソッドの戻り値の型が[{3}]）からpublicで戻り値を返すメソッド[{4}]が見つかりません。"),
    DOMA4072("式[{0}]（[{1}]番目の文字付近）に含まれる関数[{2}]が見つかりません。"),
    DOMA4073("式[{0}]（[{1}]番目の文字付近）に含まれる変数[{2}]（フィールドもしくはメソッドの戻り値の型が[{3}]）からpublicで戻り値を返すメソッド[{4}]を特定できません。"),
    DOMA4074("メッセージコード[{0}]が次の例外により生成されます。{1}"),
    DOMA4076("パラメータの型は配列型でなければいけません。"),
    DOMA4078("パラメータの数は0でなければいけません。"),
    DOMA4079("クラス[{0}]のソースファイルの生成に失敗しました。原因は次のものです。{1}"),
    DOMA4084("プロパティ[{0}]が、エンティティクラス[{1}]に見つかりません。"),
    DOMA4085("プロパティ[{0}]が、エンティティクラス[{1}]に見つかりません。"),
    DOMA4086("アノテーション[{0}]とアノテーション[{1}]が競合しています。これらは同じフィールドに注釈できません。"),
    DOMA4087("アノテーション[{0}]とアノテーション[{1}]が競合しています。これらは同じメソッドに注釈できません。"),
    DOMA4088("@Idもしくは@Versionを注釈する場合、falseを指定してはいけません。"),
    DOMA4089("@Idもしくは@Versionを注釈する場合、falseを指定してはいけません。"),
    DOMA4090("注釈プロセッサ[{0}]でクラス[{1}]の処理を開始しました。"),
    DOMA4091("注釈プロセッサ[{0}]でクラス[{1}]の処理を終了しました。"),
    DOMA4092("SQLファイル[{0}]の妥当検査に失敗しました（[{2}]行目[{3}]番目の文字付近）。詳細は次のものです。{4} SQL[{1}]。"),
    DOMA4093("@Versionは数値に互換のある型のプロパティに対してのみ有効です。"),
    DOMA4095("@GeneratedValueは数値に互換のある型のプロパティに対してのみ有効です。"),
    DOMA4096("クラス[{0}]は、永続対象の型としてサポートされていません。@ExternalDomainでマッピングすることを意図している場合、登録や設定が不足している可能性があります。@DomainConvertersを注釈したクラスと注釈処理のオプション（doma.domain.converters）を見直してください。"),
    DOMA4097("戻り値のクラスは、[{0}]でなければいけません。"),
    DOMA4098("@Outが注釈されたパラメータの型は、org.seasar.doma.jdbc.Referenceでなければいけません。"),
    DOMA4100("Referenceの実型引数の型[{0}]はサポートされていません。"),
    DOMA4101("@Inが注釈されるパラメータとして型[{0}]はサポートされていません。"),
    DOMA4102("型[{0}]は永続対象としてサポートされていません。"),
    DOMA4103("型[{0}]をパラメータにもつ非privateなコンストラクタが見つかりません。コンストラクタを定義するか、ファクトリメソッドを利用したい場合は@DomainのfactoryMethod属性にメソッド名を指定してください。"),
    DOMA4104("アクセッサメソッド[{0}]が見つかりません。アクセッサメソッドは、型[{1}]を戻り値とする非privateで引数なしのインスタンスメソッドでなければいけません。"),
    DOMA4105("クラスまたは列挙型以外には注釈できません"),
    DOMA4106("ファクトリメソッド[{0}]が見つかりません。ファクトリメソッドは、型[{1}]を戻り値とし型[{2}]をパラメータにもつ、非privateなstaticメソッドでなければいけません。また、メソッドの型パラメータはクラスの型パラメータと同一でなければいけません。ファクトリメソッドを定義するか、ファクトリメソッドが不要な場合は@DomainのfactoryMethodに\"new\"と指定しコンストラクタを定義してください。"),
    DOMA4107("@Domainを注釈したクラスには型パラメータを定義できません。"),
    DOMA4108("Referenceには実型引数が必須です。"),
    DOMA4109("戻り値であるjava.lang.Iterableのサブタイプ[{0}]には実型引数が必須です。"),
    DOMA4111("@InOutが注釈されたパラメータの型は、org.seasar.doma.jdbc.Referenceでなければいけません。"),
    DOMA4112("パラメータの型[{0}]をワイルカード型にしてはいけません。"),
    DOMA4113("戻り値の型[{0}]をワイルカード型にしてはいけません。"),
    DOMA4114("式[{0}]（[{1}]番目の文字付近）に含まれる変数[{2}]の型[{3}]にインスタンスフィールド[{4}]が見つかりません。"),
    DOMA4115("式[{0}]（[{1}]番目の文字付近）に含まれるコンストラクタ[{2}]が見つかりません。"),
    DOMA4116("式[{0}]（[{1}]番目の文字付近）に含まれる比較演算子[{2}]の左被演算子[{3}]の型[{4}]と右被演算子[{5}]の型[{6}]が異なっています。"),
    DOMA4117("式[{0}]（[{1}]番目の文字付近）に含まれる論理演算子[{2}]の左被演算子[{3}]の型[{4}]がboolean/Boolean型ではありません。"),
    DOMA4118("式[{0}]（[{1}]番目の文字付近）に含まれる論理演算子[{2}]の右被演算子[{3}]の型[{4}]がboolean/Boolean型ではありません。"),
    DOMA4119("式[{0}]（[{1}]番目の文字付近）に含まれる論理演算子[{2}]の被演算子[{3}]の型[{4}]がboolean/Boolean型ではありません。"),
    DOMA4120("式[{0}]（[{1}]番目の文字付近）に含まれる算術演算子[{2}]の左被演算子[{3}]の型[{4}]が数値型ではありません。"),
    DOMA4121("式[{0}]（[{1}]番目の文字付近）に含まれる算術演算子[{2}]の右被演算子[{3}]の型[{4}]が数値型ではありません。"),
    DOMA4122("SQLファイル[{0}]の妥当検査に失敗しました。メソッドのパラメータ[{1}]がSQLファイルで参照されていません。"),
    DOMA4124("ミュータブルなエンティティクラスは非privateな引数なしのコンストラクタを持たねばなりません。イミュータブルにするには@Entityのimmutable要素にtrueを設定してください。"),
    DOMA4125("@OriginalStatesが重複しています。@OriginalStatesが注釈されたフィールドはクラス階層中に1つでなければいけません。"),
    DOMA4126("文字の連結を行う場合、式[{0}]（[{1}]番目の文字付近）に含まれる演算子[{2}]の右被演算子[{3}]の型[{4}]はString/Character/charのいずれかでなければいけません。数値の加算を行う場合、両被演算子は数値型でなければいけません。"),
    DOMA4127("式[{0}]（[{1}]番目の文字付近）に含まれるコンストラクタ[{2}]を特定できません。"),
    DOMA4132("@DomainのfactoryMethod要素の値が\"new\"の場合、クラスはabstractであってはいけません。"),
    DOMA4135("@OriginalStatesが注釈されたフィールドの型はエンティティのクラス[{0}]と同じでなければいけません。"),
    DOMA4138("式[{0}]（[{1}]番目の文字付近）に含まれるクラス[{2}]が見つかりません。"),
    DOMA4139("式[{0}]（[{1}]番目の文字付近）に含まれる比較演算子[{2}]の被演算子にnullリテラルは使用できません。"),
    DOMA4140("SQLファイル[{0}]の妥当検査に失敗しました（[{2}]行目[{3}]番目の文字付近）。/*%if ...*/の式[{4}]が型[{5}]として評価されましたが、boolean/Boolean型でなければいけません。SQL[{1}]"),
    DOMA4141("SQLファイル[{0}]の妥当検査に失敗しました（[{2}]行目[{3}]番目の文字付近）。/*%elseif ...*/の式[{4}]が型[{5}]として評価されましたが、boolean/Boolean型でなければいけません。SQL[{1}]"),
    DOMA4143("SQLファイル[{0}]の取得ができません。原因は次のものです。{1}"),
    DOMA4144("ディレクトリ[{0}]の子ファイルを認識できませんでした。"),
    DOMA4145("式[{0}]（[{1}]番目の文字付近）に含まれるクラス[{2}]が見つかりません。"),
    DOMA4146("式[{0}]（[{1}]番目の文字付近）に含まれるクラス[{2}]のpublicで戻り値を返すstaticメソッド[{3}]が見つかりません。"),
    DOMA4147("式[{0}]（[{1}]番目の文字付近）に含まれるクラス[{2}]のpublicで戻り値を返すstaticメソッド[{3}]を特定できません。"),
    DOMA4148("式[{0}]（[{1}]番目の文字付近）に含まれるクラス[{2}]にstaticフィールド[{3}]が見つかりません。"),
    DOMA4149("SQLファイル[{0}]の妥当検査に失敗しました（[{2}]行目[{3}]番目の文字付近）。/*%for ...*/の式[{4}]が型[{5}]として評価されましたが、java.lang.Iterable型でなければいけません。SQL[{1}]"),
    DOMA4150("SQLファイル[{0}]の妥当検査に失敗しました（[{2}]行目[{3}]番目の文字付近）。/*%for ...*/の式[{4}]の型[{5}]の実型引数が不明です。SQL[{1}]"),
    DOMA4153("SQLファイル[{0}]の妥当検査に失敗しました（[{2}]行目[{3}]番目の文字付近）。バインド変数[{4}]に対応するパラメータの型は基本型もしくはドメインクラスでなければいけません。しかし、実際の型は[{5}]です。型を間違えていませんか？もしくはフィールドアクセスやメソッド呼び出しの記述を忘れていませんか？SQL[{1}]"),
    DOMA4154("戻り値のエンティティクラス[{0}]は抽象型であってはいけません。"),
    DOMA4155("戻り値のjava.util.Listに対する実型引数のエンティティクラス[{0}]は抽象型であってはいけません。"),
    DOMA4156("戻り値のjava.util.Listに対する実型引数のエンティティクラス[{0}]は抽象型であってはいけません。"),
    DOMA4157("java.util.Listに対する実型引数のエンティティクラス[{0}]は抽象型であってはいけません。"),
    DOMA4159("java.lang.Iterableのサブタイプには実型引数が必須です。"),
    DOMA4160("java.lang.Iterableのサブタイプをワイルカード型にしてはいけません。"),
    DOMA4161("SQLファイル[{0}]の妥当検査に失敗しました（[{2}]行目[{3}]番目の文字付近）。括弧の前に位置するバインド変数[{4}]に対応するパラメータの型は基本型もしくはドメインクラスを要素としたjava.lang.Iterableのサブタイプでなければいけません。しかし、実際の型は[{5}]です。型を間違えていませんか？もしくはフィールドアクセスやメソッド呼び出しの記述を忘れていませんか？。SQL[{1}]"),
    DOMA4163("ユーザー定義の設定クラスは抽象型であってはいけません。クラス[{0}]は抽象型です。"),
    DOMA4164("ユーザー定義の設定クラスは引数なしのpublicなコンストラクタを持たなければいけません。クラス[{0}]には引数なしのpublicなコンストラクタが見つかりません。"),
    DOMA4166("エンティティリスナークラスは抽象型であってはいけません。クラス[{0}]は抽象型です。"),
    DOMA4167("エンティティリスナークラスは引数なしのpublicなコンストラクタを持たなければいけません。クラス[{0}]には引数なしのpublicなコンストラクタが見つかりません。"),
    DOMA4168("org.seasar.doma.jdbc.id.TableIdGeneratorの実装クラスは抽象型であってはいけません。クラス[{0}]は抽象型です。"),
    DOMA4169("org.seasar.doma.jdbc.id.TableIdGeneratorの実装クラスは引数なしのpublicなコンストラクタを持たなければいけません。クラス[{0}]には引数なしのpublicなコンストラクタが見つかりません。"),
    DOMA4170("org.seasar.doma.jdbc.id.SequenceIdGeneratorの実装クラスは抽象型であってはいけません。クラス[{0}]は抽象型です。"),
    DOMA4171("org.seasar.doma.jdbc.id.SequenceIdGeneratorの実装クラスは引数なしのpublicなコンストラクタを持たなければいけません。クラス[{0}]には引数なしのpublicなコンストラクタが見つかりません。"),
    DOMA4172("戻り値の型はvoidでなければいけません。"),
    DOMA4173("パラメータの数は0でなければいけません。"),
    DOMA4174("列挙型以外には注釈できません"),
    DOMA4176("アクセッサメソッド[{0}]が見つかりません。アクセッサメソッドは、型[{1}]を戻り値とする非privateで引数なしのインスタンスメソッドでなければいけません。"),
    DOMA4177("ファクトリメソッド[{0}]が見つかりません。ファクトリメソッドは、型[{1}]を戻り値とし型[{2}]をパラメータにもつ、非privateなstaticメソッドでなければいけません。"),
    DOMA4179("@Domainが注釈されたクラスはトップレベルのクラスでなければいけません。"),
    /** SQLファイルに埋め込み変数コメントが含まれていることを示す警告メッセージ */
    DOMA4181("SQLファイル[{0}]に埋め込み変数コメントが含まれています。バッチの中で実行されるSQLは一定であるため、埋め込み変数コメントにより動的なSQLを発行しようとしても意図したSQLにならない可能性があります。この警告を抑制するには、メソッドに@Suppress(message = Message.DOMA4181)と注釈してください。"),
    /** SQLファイルに条件コメントが含まれていることを示す警告メッセージ */
    DOMA4182("SQLファイル[{0}]に条件コメントが含まれています。バッチの中で実行されるSQLは一定であるため、条件コメントにより動的なSQLを発行しようとしても意図したSQLにならない可能性があります。この警告を抑制するには、メソッドに@Suppress(message = Message.DOMA4182)と注釈してください。"),
    /** SQLファイルに繰り返しコメントが含まれていることを示す警告メッセージ */
    DOMA4183("SQLファイル[{0}]に繰り返しコメントが含まれています。バッチの中で実行されるSQLは一定であるため、繰り返しコメントにより動的なSQLを発行しようとしても意図したSQLにならない可能性があります。この警告を抑制するには、メソッドに@Suppress(message = Message.DOMA4183)と注釈してください。"),
    DOMA4184("列挙型に@Domainを注釈する場合、factoryMethod属性に\"new\"は指定できません（\"new\"はコンストラクタで生成することを示します）。staticで非privateなファクトリメソッドの名前を指定してください。"),
    DOMA4185(" ... /** SQLが長すぎるため最初の{0}文字のみを表示しています。 */"),
    DOMA4186("java.util.Listに対する実型引数の型[{0}]はサポートされていません。サポートされている型は次のものです。基本型、ドメインクラス、エンティティクラス、java.util.Map<String, Object>。"),
    DOMA4187("@Daoが注釈されたインタフェースは2つ以上のインタフェースをextendsできません。"),
    DOMA4188("@Daoが注釈されたインタフェースは@Daoが注釈されてないインタフェース[{0}]をextendsできません。"),
    DOMA4189("式[{0}]（[{1}]番目の文字付近）の関数[{2}]の解決に失敗しました。注釈処理のオプションdoma.expr.functionsに指定されたクラス[{3}]が見つかりません。"),
    DOMA4190("式[{0}]（[{1}]番目の文字付近）の関数[{2}]の解決に失敗しました。注釈処理のオプションdoma.expr.functionsに指定されたクラス[{3}]はorg.seasar.doma.expr.ExpressionFunctionsのサブタイプでなければいけません。"),
    DOMA4191("@ExternalDomainはorg.seasar.doma.jdbc.domain.DomainConverterのサブタイプにのみ注釈できます。"),
    DOMA4192("@ExternalDomainを注釈したクラスは抽象型であってはいけません。クラス[{0}]は抽象型です。"),
    DOMA4193("@ExternalDomainを注釈したクラスは引数なしのpublicなコンストラクタを持たなければいけません。クラス[{0}]には引数なしのpublicなコンストラクタが見つかりません。"),
    DOMA4194("org.seasar.doma.jdbc.domain.DomainConverterの第2型引数に指定された型[{0}]は永続対象としてサポートされていません。"),
    DOMA4196("型[{0}]が@ExternalDomainで注釈されていません。"),
    DOMA4197("org.seasar.doma.jdbc.domain.DomainConverterの第1型引数に指定された型[{0}]のパッケージがデフォルトパッケージです。サポートされていません。"),
    DOMA4198("@ExternalDomainが注釈されたクラスはトップレベルでなければいけません。"),
    DOMA4199("org.seasar.doma.jdbc.domain.DomainConverterの第1型引数に指定された型[{0}]はトップレベルでなければいけません。"),
    DOMA4200("注釈処理のオプション domain.converters で指定されたクラス[{0}]が見つかりません。"),
    DOMA4201("注釈処理のオプション domain.converters で指定されたクラス[{0}]に@DomainConvertersが注釈されていません。"),
    DOMA4202("org.seasar.doma.jdbc.entity.EntityListenerの型引数が解決されていません。"),
    DOMA4203("org.seasar.doma.jdbc.domain.DomainConverterの第1型引数に指定された型[{0}]への型引数はすべてワイルドカードでなければいけません。"),
    DOMA4204("クラス[{0}]の原型はエンティティプロパティに使用できません。"),
    DOMA4205("クラス[{0}]の型引数にワイルドカードや型パラメータを含むものはエンティティプロパティに使用できません。"),
    DOMA4206("クラス[{0}]の原型はDaoメソッドの戻り値に使用できません。"),
    DOMA4207("クラス[{0}]の型引数にワイルドカードや型パラメータを含むものはDaoメソッドの戻り値に使用できません。"),
    DOMA4208("クラス[{0}]の原型はDaoメソッドのパラメータに使用できません。"),
    DOMA4209("クラス[{0}]の型引数にワイルドカードや型パラメータを含むものはDaoメソッドのパラメータに使用できません。"),
    DOMA4210("クラス[{0}]の原型はIterableのサブタイプの実型引数に使用できません。"),
    DOMA4211("クラス[{0}]の型引数にワイルドカードや型パラメータを含むものはIterableの実型引数に使用できません。"),
    DOMA4212("クラス[{0}]の原型はIterableのサブタイプの実型引数に使用できません。"),
    DOMA4213("クラス[{0}]の型引数にワイルドカードや型パラメータを含むものはIterableの実型引数に使用できません。"),
    DOMA4218("クラス[{0}]の原型はReferenceの実型引数に使用できません。"),
    DOMA4219("クラス[{0}]の型引数にワイルドカードや型パラメータを含むものはReferenceの実型引数に使用できません。"),
    /** どのメソッドにもマッピングされないSQLファイルが存在することを示す警告メッセージ */
    DOMA4220("どのメソッドにもマッピングされないSQLファイル[{0}]が存在します。メソッドの名前やアノテーションのsqlFile属性を確認してください。この警告を抑制するには、Daoインタフェースに@Suppress(message = Message.DOMA4220)と注釈してください。"),
    DOMA4221("イミュータブルなエンティティクラスには非privateなコンストラクタが必要です。コンストラクタのパラメータの型と名前は永続対象フィールドに一致しなければいけません。"),
    DOMA4222("イミュータブルなエンティティクラスを@Insertや@Updateや@Deleteが注釈されたメソッドのパラメータとする場合、戻り値はorg.seasar.doma.jdbc.Result<E>でなければいけません。型パラメータ E の実型引数にはパラメータと同じエンティティクラスを指定してください。"),
    DOMA4223("イミュータブルなエンティティクラスを@BatchInsertや@BatchUpdateや@BatchDeleteが注釈されたメソッドのパラメータとする場合、戻り値はorg.seasar.doma.jdbc.BatchResult<E>でなければいけません。型パラメータEの実型引数にはパラメータと同じエンティティクラスを指定してください。"),
    DOMA4224("イミュータブルなエンティティクラスのフィールドには@OriginalStatesを注釈できません。"),
    DOMA4225("イミュータブルなエンティティクラスの永続対象フィールドにはfinal修飾子が必須です。"),
    DOMA4226("@Entityのimmutable要素の値はエンティティクラスの継承階層で同一でなければいけません。"),
    DOMA4227("エンティティリスナークラスの型パラメータは1つ以下でなければいけません。"),
    DOMA4228("エンティティリスナークラスの型パラメータ[{0}]がクラス階層の中でorg.seasar.doma.jdbc.entity.EntityListerの型引数として渡されていません。"),
    DOMA4229("エンティティリスナークラスの型パラメータ[{0}]の上限境界[{1}]がエンティティクラス[{2}]と互換性がありません。"),
    DOMA4230("親エンティティクラスから引き継がれたエンティティリスナークラス[{0}]には、エンティティクラス[{1}]を型引数で受けるための型パラメータが1つ必要です"),
    DOMA4231("親エンティティクラスから引き継がれたエンティティリスナークラス[{0}]の型パラメータ[{1}]の上限境界[{2}]がエンティティクラス[{3}]と互換性がありません。"),
    DOMA4232("クラス[{0}]の原型は使用できません。"),
    DOMA4233("クラス[{0}]の型引数にワイルドカードや型パラメータは使用できません。基本型やドメインクラスを指定できます。"),
    DOMA4234("java.util.Optionalに対する実型引数のエンティティクラス[{0}]は抽象型であってはいけません。"),
    DOMA4235("java.util.Optionalに対する実型引数の型[{0}]はサポートされていません。サポートされている型は次のものです。基本型、ドメインクラス、エンティティクラス。"),
    DOMA4236("クラス[{0}]の原型は使用できません。"),
    DOMA4237("クラス[{0}]の型引数にワイルドカードや型パラメータは使用できません。基本型やドメインクラスを指定できます。"),
    DOMA4238("クラス[{0}]の原型はOptionalの実型引数に使用できません。"),
    DOMA4239("クラス[{0}]の型引数にワイルドカードや型パラメータを含むものはOptionalの実型引数に使用できません。"),
    DOMA4240("パラメータの型[{0}]を原型にしてはいけません。"),
    DOMA4241("パラメータの型[{0}]をワイルカード型にしてはいけません。"),
    DOMA4242("クラス[{0}]の原型はStreamの実型引数に使用できません。"),
    DOMA4243("クラス[{0}]の型引数にワイルドカードや型パラメータを含むものはStreamの実型引数に使用できません。"),
    DOMA4244("Functionの1番目の実型引数の型は、java.util.stream.Streamでなければいけません。"),
    DOMA4245("Streamの実型引数の型がサポートされていない型です。"),
    DOMA4246("戻り値の型[{0}]とFunctionの2番目の実型引数の型[{1}]が一致していません。"),
    DOMA4247("@Selectのstrategy要素にSelectStrategyType.STREAMを設定した場合、Function型のパラメータが必要です。"),
    DOMA4248("Function型のパラメータを利用するには、strategy要素にSelectStrategyType.STREAMを設定しなければいけません。"),
    DOMA4249("Function型のパラメータは複数指定できません。"),
    DOMA4250("Streamの実型引数に抽象型のエンティティクラス[{0}]は指定できません。"),
    DOMA4251("valueType要素にプリミティブ型を指定している場合、acceptNull要素にtrueを指定できません。"),
    DOMA4252("defaultメソッドにアノテーション[{0}]は注釈できません。"),
    DOMA4253("org.seasar.doma.Configのサブタイプ以外には注釈できません。"),
    DOMA4254("メソッド[{0}]が見つかりません。メソッドの修飾子はpublic static、戻り値の型はこのクラス[{1}]、パラメータの数は0、でなければいけません。"),
    DOMA4255("クラス[{0}]にメソッド[{1}]が見つかりません。"),
    DOMA4256("@SingletonConfigを注釈したクラスのコンストラクタはprivateでなければいけません。"),
    DOMA4257("SQLファイル[{0}]の妥当検査に失敗しました（[{2}]行目[{3}]番目の文字付近）。/*%expand ...*/の式が使用されていますが、カラムの自動展開ができません。メソッドに@Selectが注釈され、結果セットのレコードがエンティティクラスにマッピングされていることを確認してください。SQL[{1}]"),
    DOMA4258("パラメータの型[{0}]を原型にしてはいけません。"),
    DOMA4259("パラメータの型[{0}]の1番目もしくは3番目の実型引数をワイルカード型にしてはいけません。"),
    DOMA4260("クラス[{0}]の原型はCollectorの1番目の実型引数に使用できません。"),
    DOMA4261("クラス[{0}]の型引数にワイルドカードや型パラメータを含むものはCollectorの1番目の実型引数に使用できません。"),
    DOMA4262("Collectorの1番目の実型引数の型がサポートされていない型です。"),
    DOMA4263("Collectorの1番目の実型引数に抽象型のエンティティクラス[{0}]は指定できません。"),
    DOMA4264("Collector型のパラメータは複数指定できません。"),
    DOMA4265("戻り値の型[{0}]とCollectorの3番目の実型引数の型[{1}]が一致していません。"),
    DOMA4266("@Selectのstrategy要素にSelectStrategyType.COLLECTを設定した場合、Collector型のパラメータが必要です。"),

    DOMA4300("型[{0}]の処理中に例外が発生しました。注釈処理とは直接関係ない場所でコンパイルエラーがありませんか？"),

    // other
    DOMA5001("JDBCドライバがロードされていない可能性があります。まず、JDBCドライバがクラスパスにあることを確認してください。次に、JDBCドライバが自動でロードされない場合は、Class.forNameで明示的にロードしてください。 ex) Class.forName(\"oracle.jdbc.driver.OracleDriver\")"),
    DOMA5002("urlプロパティが設定されていません。"), ;

    private final String messagePattern;

    private Message(String messagePattern) {
        this.messagePattern = messagePattern;
    }

    @Override
    public String getCode() {
        return name();
    }

    @Override
    public String getMessagePattern() {
        return messagePattern;
    }

    @Override
    public String getMessage(Object... args) {
        String simpleMessage = getSimpleMessageInternal(args);
        String code = name();
        return "[" + code + "] " + simpleMessage;
    }

    @Override
    public String getSimpleMessage(Object... args) {
        return getSimpleMessageInternal(args);
    }

    protected String getSimpleMessageInternal(Object... args) {
        try {
            ResourceBundle bundle = ResourceBundle
                    .getBundle(MessageResourceBundle.class.getName());
            String code = name();
            String pattern = bundle.getString(code);
            return MessageFormat.format(pattern, args);
        } catch (Throwable throwable) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            throwable.printStackTrace(pw);
            return "[DOMA9001] Failed to get a message because of following error : "
                    + sw;
        }
    }
}
