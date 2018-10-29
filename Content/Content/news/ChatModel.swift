//
//  ChatModel.swift
//  Content
//
//  Created by fcn on 2018/10/29.
//  Copyright © 2018年 fcn. All rights reserved.
//

import UIKit

class ChatModel: NSObject {

    var content = ""
    var chatCount = 0
    
    init(content: String, chatCount: Int) {
        self.content = content
        self.chatCount = chatCount
    }
    
    
}
