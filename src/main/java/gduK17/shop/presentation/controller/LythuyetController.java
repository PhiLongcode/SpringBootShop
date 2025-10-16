package gduK17.shop.presentation.controller;

public class LythuyetController {

        /*spring bean là các đối tượng được quản lý bởi Spring IoC Container
         * Spring bean được định nghĩa trong file cấu hình XML hoặc thông qua các
         *  annotation như @Component
         * Có thể built-in bean(HttpServletRequest, HttpServletResponse, Model,
         *  ModelMap, Map)
         * hoặctao class và khai báo  cho spring quản lý Hanghoa a=new Hanghoa();;
         * DI(Dependency Injection) là kỹ thuật tiêm các phụ thuộc vào một đối tượng
         *  thay vì để đối tượng tự tạo hoặc tìm kiếm các phụ thuộc của nó
         * Có 3 cách DI: Constructor Injection, Setter Injection, Field Injection
         * @Autowired là annotation dùng để tự động tiêm các phụ thuộc vào một bean
         * @Qualifier được sử dụng để chỉ định rõ ràng bean nào sẽ được tiêm khi có
         *  nhiều bean cùng kiểu
         * @Lazy là annotation dùng để đánh dấu một bean sẽ được khởi tạo
         * @Value l giá trị từ file application.properties vào một biến trong bean
         * @Primary được sử dụng để đánh dấu một bean là ưu tiên khi có nhiều bean
         * @Entity: Đánh dấu một lớp là một thực thể (entity) trong JPA, ánh xa
         * voới một bảng trong cơ sở dữ liệu.
         * Mỗi entity =một bảng trong CSDL
         * Dùng khi muốn lưu trữ và truy xuất dữ liệu từ CSDL
         * @Table: Chỉ định tên bảng trong CSDL mà entity ánh xạ tới.
         * Đặt tên bảng trong DB(nếu khác tn class)
         * CÓ thể theeam ràng buoc(constraint) cho bảng
         * Dung khi muốn tùy chỉnh tên bảng hoặc thêm ràng buộc
         * @Id: Đánh dấu thuộc tính là khóa chính (primary key) của entity.
         * Xác định thuộc tính duy nhất cho mỗi bản ghi trong bảng
         * @UniqueConstraint: Định nghĩa các ràng buộc duy nhất (unique constraints)
         * trên một hoặc nhiều cột trong bảng.
         * @column: Chỉ định tên cột trong bảng mà thuộc tính ánh xạ tới.
         * Dùng khi muốn thay đổi chi tiết mapping giữa thuộc tính và cột
         * @GeneratedValue: Chỉ định chiến lược sinh giá trị tự động cho khóa chính
         * + AUTO: Tự động chọn chiến lược phù hợp với CSDL
         * + IDENTITY: Sử dụng cột tự tăng của CSDL
         * + SEQUENCE: Sử dụng chuỗi trong CSDL (thường dùng với Oracle
         * + TABLE: Sử dụng bảng riêng để sinh giá trị
         * Dùng khi muốn tự động sinh giá trị cho khóa chính
         * @Temporal: Chỉ định kiểu dữ liệu thời gian cho thuộc tính ngày tháng
         * + temporalType.DATE: Chỉ lưu ngày (yyyy-MM-dd)
         * + temporalType.TIME: Chỉ lưu giờ (HH:mm:ss)
         * + temporalType.TIMESTAMP: Lưu cả ngày và giờ (yyyy-MM-dd HH:mm
         * @OneToMany: quan hệ một-nhiều giữa hai entity vi du: loai va hanghoa
         * @ManyToOne: quan hệ nhiều-một giữa hai entity
         * @OneToOne: quan hệ một-một giữa hai entity
         * @ManyToMany: quan hệ nhiều-nhiều giữa hai entity vi du: sanpham va mausac
         * @JoinColumn: Chỉ định cột ngoại (foreign key) trong quan hệ giữa hai entity
         * @JoinTable: Chỉ định bảng liên kết trong quan hệ nhiều-nhiều giữa
         * */

}
