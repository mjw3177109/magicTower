package com.tower;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JFrame {
    //窗口长度
    int width =800;
    int height =610;
    //定义游戏模式 0代表未开始 1代表开始游戏 2代表查看排行榜 3代表暂停
    int state =0;
    //定义a作为游戏模式的赋值
    int a =0;
    //定义双缓存图片 预加载
    Image offScreenImage =null;
    int map1[][] =new int[13][13];


   int map2[][] =new int[][]{
            {0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0},
    };


    //窗口启动方法
    public void launch(){

        setTitle("MagicTower");
        //窗口初始大小
        setSize(width,height);
        //使屏幕居中
        setLocationRelativeTo(null);
        //添加关闭事件
        setDefaultCloseOperation(3);
        //用户不能调整大小
        setResizable(false);
        //使窗口可见
        setVisible(true);
        //添加键盘监视器
//        this.addKeyListener(new KeyMonitor());
        //重绘制
        while(true){

            repaint();
            //每60秒重新绘制一次图片
            try{
                Thread.sleep(60);
            }catch (Exception e){
                e.printStackTrace();
            }

        }



    }
    @Override
    public void paint(Graphics g){
        //创建和窗口一样大小的Image图片
        if (offScreenImage == null){
            offScreenImage=this.createImage(width,height);
        }

        //获取图片的画笔
        Graphics gImage =offScreenImage.getGraphics();
        //设置画笔颜色
        gImage.setColor(Color.gray);

        //绘制实心矩形
        gImage.fillRect(0,0,width,height);

        //改变画笔颜色
        gImage.setColor(Color.blue);
        //改变文字大小和样式
        gImage.setFont(new Font("伪宋",Font.BOLD,50));
        if (state ==0){

            //添加文字
            gImage.drawString("选择游戏模式",220,100);
            gImage.drawString("选择单人模式",220,200);
            gImage.drawString("选择双人模式",220,300);
            //绘制指针
           // gImage.drawImage(select,160,y,null);
            for (int i = 0; i < map2.length; i++) {

            }

        }else if(state ==2){

            gImage.setFont(new Font("伪宋",Font.BOLD,70));
            gImage.drawString("游戏排行榜",220,150);
            gImage.drawString("章敏 200分",220,251);
            gImage.drawString("卓小弟 200分",220,341);


        } else if(state ==3){

            gImage.setFont(new Font("伪宋",Font.BOLD,70));
            gImage.drawString("游戏暂停",220,200);

        }
        /** 将图片一次性绘制到窗口中*/
        g.drawImage(offScreenImage,0,0,null);


    }


}
