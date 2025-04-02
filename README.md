Bước 1: Sao chép URL của Repository
Truy cập GitHub/GitLab/Bitbucket nơi chứa project của bạn.

Nhấp vào nút Code (hoặc Clone) và sao chép đường link HTTPS hoặc SSH của repository.

Bước 2: Mở Android Studio
Khởi động Android Studio

Trên màn hình Welcome to Android Studio, chọn Get from VCS (Version Control System).

Bước 3: Clone Repository về máy
Ở phần Version Control, chọn Git.

Dán URL repository đã sao chép vào ô URL.

Chọn thư mục trên máy để lưu project trong ô Directory.

Nhấn Clone để tải source code về máy.

Bước 4: Mở Project trong Android Studio
Sau khi clone hoàn tất, Android Studio sẽ tự động mở project. Nếu không, bạn có thể:

Vào File > Open, tìm đến thư mục chứa project vừa clone và mở nó.

Bước 5: Chạy Project
Đợi Android Studio tải dependencies (Gradle sync hoàn tất).

Nếu có thông báo cập nhật Gradle hoặc SDK, hãy tiến hành cập nhật.

Kết nối máy ảo hoặc điện thoại thật, sau đó nhấn Run (Shift + F10) để chạy project.

Nếu gặp lỗi trong quá trình import, hãy kiểm tra:
✅ Đã cài đặt Git trên máy (chạy lệnh git --version để kiểm tra).
✅ Đường dẫn Git được cấu hình trong Android Studio > Settings > Version Control > Git.
✅ Gradle và các dependencies đã tải đầy đủ.
