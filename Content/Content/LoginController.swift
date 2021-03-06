//
//  LoginController.swift
//  Content
//
//  Created by fcn on 2018/10/8.
//  Copyright © 2018年 fcn. All rights reserved.
//

import UIKit
import SVProgressHUD
import Alamofire

class LoginController: UIViewController {

    @IBOutlet weak var registBtn: UIButton!
    @IBOutlet weak var loginBtn: UIButton!
    
    @IBOutlet weak var username: UITextField!
    @IBOutlet weak var password: UITextField!
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        
        
        registBtn.layer.cornerRadius = 5
        registBtn.layer.masksToBounds = true
        
        loginBtn.layer.cornerRadius = 5
        loginBtn.layer.masksToBounds = true
        
        
    }
    
    
    @IBAction func didClickLogin(_ sender: UIButton) {
        
        view.endEditing(true)
        
        if (username.text?.isEmpty)! || (password.text?.isEmpty)! {
            SVTool.showError(info: "请输入完整")
            return
        }
        
        let m_parameters: Parameters = [
            "username": username.text!,
            "password": password.text!
        ]
        NetTool.Get(url: "\(BACKURL)login.action", parameters: m_parameters) { (json) in
            if let json = json {
                print(json)
                let status = json["status"].intValue
                if status == 1 {
                    
                    let storyboard = UIStoryboard(name: "Main", bundle: nil)
                    let vc = storyboard.instantiateViewController(withIdentifier: "MainController")
                    let nav = UINavigationController(rootViewController: vc)
                    
                    let tab =  UITabBarController()
                    tab.addChildViewController(nav)
                    nav.tabBarItem.title = "精彩内容"
                    nav.tabBarItem.image = UIImage(named: "_内容2")
                    let collect = storyboard.instantiateViewController(withIdentifier: "MineController")
                    let nav1 = UINavigationController(rootViewController: collect)
                    
                    let chat = storyboard.instantiateViewController(withIdentifier: "ChatsController")
                    let nav2 = UINavigationController(rootViewController: chat)
                    nav2.tabBarItem.title = "话题讨论"
                    nav2.tabBarItem.image = UIImage(named: "话题-1")
                    tab.addChildViewController(nav2)
                    
                    nav1.tabBarItem.title = "我的"
                    nav1.tabBarItem.image = UIImage(named: "我的")
                    tab.addChildViewController(nav1)
                    UIApplication.shared.keyWindow?.rootViewController = tab

                    let username = json["user"]["name"].stringValue
                    let userid = json["user"]["id"].stringValue
                    DataTool.cacheInfo(value: username, key: "username")
                    DataTool.cacheInfo(value: userid, key: "userid")
                    
                    
                } else {
                    SVTool.showError(info: "用户名或密码错误")
                }
            }
        }
    }
    

//    @IBAction func didClickRegist(_ sender: UIButton) {
//        
//        
//    }
    

}
