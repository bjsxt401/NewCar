package cn.sxt.service.carManager.impl;

import cn.sxt.entity.Cars;
import cn.sxt.exception.service.ServiceException;
import cn.sxt.mapper.CarMapper;
import cn.sxt.service.carManager.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by beichunming on 2017/5/5.
 */
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarMapper carMapper;

    @Override
    public void addCar(Cars car, MultipartFile uploadFile, HttpServletRequest request) throws ServiceException {
        // 判断文件类型
        String contentType = uploadFile.getContentType();
        System.out.println("contentType===="+contentType);
        if (!(contentType.equals("image/png")||contentType.equals("image/jpg")||contentType.equals("image/jpeg")||contentType.equals("image/gif"))){
            throw  new ServiceException("文件类型错误");
        }
        String fileName = uploadFile.getOriginalFilename();
        if (fileName.endsWith(".png")||fileName.endsWith(".jpg")||fileName.endsWith("jepg")||fileName.endsWith(".gif")){
            // 文件类型正确
            // 解析文件内容
            try {
                String path = request.getServletContext().getRealPath("/");
                //把\ 换成/
                path = path.replace("\\","/");
                //指定路径，必须现在服务器上建立文件夹
                path += "upload/img/";
                File desFile = new File(path);
                //如果没有，就创建路径
                if (!desFile.exists()){
                    desFile.mkdirs();
                }
                //获取图片格式.png
                String suffixName = fileName.substring(fileName.lastIndexOf("."));
                //保存图片的id和后缀
                String suffix = suffixName;
                long carImageId = System.nanoTime();
                //拼接成完整的图片名字
                suffixName =carImageId+suffixName;
                path = path + suffixName;
                //转存文件
                uploadFile.transferTo(new File(path));
                //向car对象赋值
                car.setCarImageid(carImageId);
                car.setSuffix(suffix);
                System.out.println("path"+path);

                this.carMapper.insertCar(car);
            }   catch (Exception e){
                e.printStackTrace();
                throw new  ServiceException();// 文件类型错误
            }
        }

    }
}
