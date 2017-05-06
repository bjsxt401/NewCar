package cn.sxt.service.carManager.impl;

import cn.sxt.entity.Cars;
import cn.sxt.exception.service.ServiceException;
import cn.sxt.mapper.CarMapper;
import cn.sxt.service.carManager.CarService;
import cn.sxt.util.Commons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by beichunming on 2017/5/5.
 */
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarMapper carMapper;

    /**
     * 添加汽车信息
     * @param car
     * @param uploadFile
     * @param request
     * @throws ServiceException
     */
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

                path += Commons.CARIMAGEPATH;
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

    /**
     * 分页查询
     * @param draw
     * @param index
     * @param pageSize
     * @param car
     * @return
     */
    @Override
    public Map<String, Object> getCarsListByPage(String draw, Integer index, Integer pageSize, Cars car) throws ServiceException{
        Map<String,Object> params = new HashMap<String,Object>();
        if(index == null)
            index = 1;
        if(pageSize == null)
            pageSize = 3;
        params.put("start", index);
        params.put("pageSize", pageSize);
        params.put("car",car);
        List<Cars> list = this.carMapper.getCarsByPage(params);

        int totalCounts = this.carMapper.getCarsCounts(params);

        Map<String, Object> info = new HashMap<String, Object>();
        info.put("pageData", list);
        info.put("total", totalCounts);
        info.put("draw", draw);

        return info;
    }

    /**
     * 通过条件搜索car
     * @param car
     * @return
     */
    @Override
    public Cars getCarByCar(Cars car) throws ServiceException{
        return this.carMapper.getCarByCar(car);
    }

    /**
     * 更新汽车信息
     * @param car
     * @param uploadFile
     * @param request
     */
    @Override
    public void updateCar(Cars car, MultipartFile uploadFile, HttpServletRequest request) throws ServiceException{
        // 判断文件类型
        String contentType = uploadFile.getContentType();
        System.out.println("contentType===="+contentType);
        if (!(contentType.equals("image/png")||contentType.equals("image/jpg")||contentType.equals("image/jpeg")||contentType.equals("image/gif"))){
            if (contentType.equals("application/octet-stream")){
                //没有改动扸
                String suffixName = car.getSuffix();
                long carImageId = car.getCarImageid();
                //向car对象赋值
                car.setCarImageid(carImageId);
                car.setSuffix(suffixName);
                this.carMapper.updateCar(car);
                System.out.println("updatecar===="+car);
                return;
            }
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

                path += Commons.CARIMAGEPATH;
                File desFile = new File(path);
                //如果没有，就创建路径
                if (!desFile.exists()){
                    desFile.mkdirs();
                }
                //获取图片格式.png
                String suffixName = null;
                suffixName = fileName.substring(fileName.lastIndexOf("."));
                if (suffixName ==null){
                    suffixName = car.getSuffix();
                }
                //保存图片的id和后缀
                String suffix = suffixName;
                long carImageId = car.getCarImageid();
                //拼接成完整的图片名字
                suffixName =carImageId+suffixName;
                path = path + suffixName;
                //转存文件
                uploadFile.transferTo(new File(path));
                //向car对象赋值
                car.setCarImageid(carImageId);
                car.setSuffix(suffix);
                System.out.println("path"+path);

                this.carMapper.updateCar(car);
            }   catch (Exception e){
                e.printStackTrace();
                throw new  ServiceException();// 文件类型错误
            }
        }
    }

    @Override
    public void deleteCar(Integer carId) throws ServiceException {
        this.carMapper.deleteCar(carId);
    }
}
