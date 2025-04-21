# 🏀 Player Manager App

這是一款基於 Android 的球員管理應用程式，可查詢、瀏覽球員名單，並導向至詳細資訊與其他功能頁面。專案使用原生 Android 技術開發，並搭配 SQLite 資料庫儲存球員資料。

## 📱 主要功能

- 顯示球員列表（從 SQLite 資料庫讀取）
- 點擊球員可查看詳細資料（透過 Intent 傳遞資料至下一頁）
- 提供按鈕跳轉至其他功能頁面（MainActivity3、MainActivity4）
- 簡潔易用的介面設計（使用 `ListView` 和原生元件）

## 🧰 使用技術

- Kotlin / Java
- Android SDK
- SQLite (本地資料庫)
- Android `Intent` / Activity 切換
- ListView & ArrayAdapter
- 原生 View 綁定與事件處理

## 🛠️ 安裝與執行方式

1. Clone 專案：
    ```bash
    git clone https://github.com/jq680106/swim.git
    ```

2. 使用 Android Studio 開啟 `APP/MyApplication2` 專案目錄

3. 執行 App 至模擬器或實機

4. 若需自定資料庫內容，請檢查 `MyDBHelper.kt` 中的 `onCreate` 方法或以 SQLite 工具預先建立資料

## 📂 專案結構簡介

