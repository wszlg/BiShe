//
//  RegistController.swift
//  Content
//
//  Created by fcn on 2018/10/8.
//  Copyright © 2018年 fcn. All rights reserved.
//

import UIKit
import Alamofire

class RegistController: UIViewController {

    @IBOutlet weak var registBtn: UIButton!
    
    
    @IBOutlet weak var username: UITextField!
    @IBOutlet weak var password: UITextField!
    @IBOutlet weak var passwordconfirm: UITextField!
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()

        registBtn.layer.cornerRadius = 5
        registBtn.layer.masksToBounds = true
        // Do any additional setup after loading the view.
    }


    @IBAction func didClickRegistBtn(_ sender: UIButton) {
        
        if (username.text?.isEmpty)! || (password.text?.isEmpty)! || (passwordconfirm.text?.isEmpty)! || passwordconfirm.text != password.text{
            SVTool.showError(info: "请输入完整")
            return
        }
        
        
        let parameters: Parameters = [
            "username" : username.text!,
            "password" : password.text!
        ]
        
        NetTool.Get(url: "\(BACKURL)register.action", parameters: parameters) { (json) in
            if let json = json {
                let status = json["status"].intValue
                if status == 1 {
                    SVTool.showSuccess(info: json["message"].stringValue)
                    
                    
                    DataTool.cacheInfo(value: json["user"]["name"].stringValue, key: "username")
                    DataTool.cacheInfo(value: json["user"]["id"].stringValue, key: "userid")
                    
                    
                    DispatchQueue.main.asyncAfter(deadline: .now() + .seconds(2), execute: {
                        
                        
//                        let storyboard = UIStoryboard(name: "Main", bundle: nil)
//                        let vc = storyboard.instantiateViewController(withIdentifier: "MainController")
//
//                        let nav = UINavigationController(rootViewController: vc)
//                        UIApplication.shared.keyWindow?.rootViewController = nav
                        
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
                        
                        
                    })

                    
                } else {
                    SVTool.showError(info: json["message"].stringValue)
                }
            }
        }
        
        
        

        
        
        
        
        
    }
    
}
