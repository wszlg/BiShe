//
//  CreateChatController.swift
//  Content
//
//  Created by fcn on 2018/10/23.
//  Copyright © 2018年 fcn. All rights reserved.
//  发起一个话题

import UIKit
import Alamofire


class CreateChatController: UIViewController {
    
    
    
    @IBOutlet weak var textView: UITextView!
    
    
    

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }


    @IBAction func didClickButton(_ sender: Any) {
        
        if textView.text.isEmpty {
            SVTool.showError(info: "请输入话题")
            return
        }
        
        let m_parameters: Parameters = [
            "userid": DataTool.getInfo(key: "userid") as! String,
            "username": DataTool.getInfo(key: "username") as! String,
            "content": textView.text!
        ]
        NetTool.Get(url: "\(BACKURL)createChat.action", parameters: m_parameters) { (json) in
            if let js = json {
                if js["status"].intValue == 1 {
                    SVTool.showSuccess(info: "创建成功")
                }
            }
        }
        
    }
    
}
